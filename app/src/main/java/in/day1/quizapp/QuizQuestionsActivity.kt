package `in`.day1.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener{
    private var Score = 0
    private var mUserName: String?= null
    // The current position of the question is being used
    private var currentPosition : Int = 0
    private var mQuestionlist: ArrayList<Question>?= null
    private var mSelectedOption: Int = 0
//    All the elements that are present in the page of the question are to be assigned when
//    when the intent is being loaded on the screen
    private var progressBar : ProgressBar?= null
    private var tvProgress : TextView?= null
    private var tvQuestion : TextView?= null
    private var ivImage : ImageView?= null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null

    private var btnSubmit: Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

//        To read the data that have been passed from previous intent
        mUserName = intent.getStringExtra(Constants.userName)
//        find the id of the elements present in the xml file
        progressBar = findViewById(R.id.tv_Progressbar)
        tvProgress = findViewById(R.id.tv_Progress)
        tvQuestion = findViewById(R.id.tv_Ques)
        ivImage = findViewById(R.id.tv_Image)

        tvOptionOne = findViewById(R.id.tv_OptionOne)
        tvOptionTwo = findViewById(R.id.tv_OptionTwo)
        tvOptionThree = findViewById(R.id.tv_OptionThree)
        tvOptionFour = findViewById(R.id.tv_OptionFour)

        btnSubmit = findViewById(R.id.btn_submit)

        mQuestionlist = Constants.getQuestions()
//        Set the onclick listener to each of the text view and submit Button
        tvOptionOne!!.setOnClickListener(this)
        tvOptionTwo!!.setOnClickListener(this)
        tvOptionThree!!.setOnClickListener(this)
        tvOptionFour!!.setOnClickListener(this)
        btnSubmit!!.setOnClickListener(this)

//        Call the setQuestion and set the question
        setQuestion()


    }

    private fun setQuestion() {
        mQuestionlist = Constants.getQuestions()
        mSelectedOption = 0
        // This the number of question loaded in the Log cat of the terminal
        progressBar?.max = mQuestionlist?.size!!

        for (x in mQuestionlist!!) {
            Log.i("Question is", "${x.Ques}")
        }
        // gets the list of the question in the question activity
        Log.i("Question ListSize is ", "${mQuestionlist!!.size}")

        val question: Question = mQuestionlist!![currentPosition]
        //        Selecting the question at the current position

        progressBar?.progress = currentPosition + 1
        //        Set the current value of the progres bar depend on the question number

        tvProgress?.text = "${currentPosition + 1}/${progressBar?.max}"
        //        Set the value of Progress value text

        tvQuestion?.text = question.Ques
        //        Set the question text

        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
        //        Set the option for all the question

        ivImage?.setImageResource(question.image)
        //        Set the image as it is stored as integer here so we use setImageResource

        if(currentPosition == mQuestionlist!!.size -1) {
            btnSubmit?.text = "FINISH"
        }
        else {
            btnSubmit?.text= "SUBMIT"
        }
//    Set the button finist for the last question and set it submit for other case
    }

    private fun defaultOptionsView() {
//        create a arraylist of the options of the textView of option
        val options = ArrayList<TextView>()

        tvOptionOne?.let {
            options.add(0,it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let {
            options.add(2,it)
        }
        tvOptionFour?.let {
            options.add(3,it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#FF000000"))
//            Set the color of all the option
            option.typeface = Typeface.DEFAULT

            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {
//        when an option is selected we set all options default first then we change the selected one
        if(mSelectedOption == -1) return
        defaultOptionsView()
//        The optionNumberSelected
        mSelectedOption = selectedOptionNumber

//        Changes the color of the text color
        tv.setTextColor(Color.parseColor("#072A6C"))

//      set the Type face of the selected text
        tv.setTypeface(tv.typeface, Typeface.BOLD)

//        Set the background of the selected option
        tv.background = ContextCompat.getDrawable(this,
        R.drawable.selected_option_border_bg
        )


    }

    private fun answerView(ans: Int, drawableView: Int) {
//        Set the color of the textview to be the one as given drawable
        when(ans) {
            1 -> tvOptionOne?.background = ContextCompat.getDrawable(this,drawableView)
            2 -> tvOptionTwo?.background = ContextCompat.getDrawable(this,drawableView)
            3 -> tvOptionThree?.background = ContextCompat.getDrawable(this,drawableView)
            4 -> tvOptionFour?.background = ContextCompat.getDrawable(this,drawableView)
        }
    }
    override fun onClick(view: View?) {
//        Which view is clicked on the screen is then checked and then it is performed with some
//        operation
        when(view?.id){
            R.id.tv_OptionOne -> tvOptionOne?.let {
                selectedOptionView(it, 1)
            }
            R.id.tv_OptionTwo -> tvOptionTwo?.let {
                selectedOptionView(it, 2)
            }
            R.id.tv_OptionThree -> tvOptionThree?.let {
            selectedOptionView(it, 3)
            }
            R.id.tv_OptionFour -> tvOptionFour?.let {
            selectedOptionView(it, 4)
            }
            R.id.btn_submit -> btnSubmit?.let {
                var answer: Int = mQuestionlist!![currentPosition].correctAns
                if(mSelectedOption == 0) {
//                    When no option is selected it pops an error
                    Toast.makeText(this,"SELECT AN OPTION", Toast.LENGTH_SHORT).show()
                }
                else if(mSelectedOption == -1) {
//                    When we move to the next question
                        currentPosition++
                        setQuestion()
                        defaultOptionsView()
                }
                else if(mSelectedOption == answer) {
//                    IF the answer is correct increment the score and change button
                    mSelectedOption = -1
                    Score ++
                    answerView(answer, R.drawable.correct_option_border_bg)
                    if(currentPosition != (mQuestionlist!!.size)-1) {
                        it.text = "NEXT QUESTION"
                    }
                    else {
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.userName, mUserName)
                        intent.putExtra(Constants.correctAns,Score.toString())
                        intent.putExtra(Constants.totalQues, mQuestionlist!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
                else {
//                    If the selected answer is wrong here
                    answerView(answer, R.drawable.correct_option_border_bg)
                    answerView(mSelectedOption,R.drawable.incorrect_option_border_bg)
                    mSelectedOption = -1
                    if(currentPosition != (mQuestionlist!!.size)-1) {
                        it.text = "NEXT QUESTION"
                    }
                    else {
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.userName, mUserName)
                        intent.putExtra(Constants.correctAns,Score.toString())
                        intent.putExtra(Constants.totalQues, mQuestionlist!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }

    }
}