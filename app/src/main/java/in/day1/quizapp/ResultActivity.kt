package `in`.day1.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

//        Elements of the result view
        val tvUserName: TextView = findViewById(R.id.userName)
        val result: TextView = findViewById(R.id.score)
        val endQ: Button = findViewById(R.id.endQuiz)

//        TO get the data passed from the previous intent
        tvUserName.text = intent.getStringExtra(Constants.userName)
        val userScore = intent.getStringExtra(Constants.correctAns)
        val totatQues = intent.getStringExtra(Constants.totalQues)
        result.text = "Score is $userScore out of $totatQues"

        endQ.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


    }
}