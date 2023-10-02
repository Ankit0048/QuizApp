package `in`.day1.quizapp

object Constants {
    // Store all the constants that we are going to get  are stored are here
    const val userName: String = "User_name"
    const val totalQues: String = "Total_Question"
    const val correctAns: String = "Correct_Answer"

    fun getQuestions() : ArrayList<Question> {
        val questionList = ArrayList<Question>()
        // Creating the list of the question on the form of Question type data class
        val ques1 = Question(
            1,
            "What Country does this flag belong now",
             R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Spain",
            "Germany",
            1
        )
        questionList.add(ques1)

        val ques2 = Question(
            2,
            "What Country does this flag belong now",
            R.drawable.ic_flag_of_australia,
            "New Zealand",
            "Australia",
            "United States of America",
            "Germany",
            2
        )
        questionList.add(ques2)

        val ques3 = Question(
            3,
            "What Country does this flag belong now",
            R.drawable.ic_flag_of_argentina,
            "Nigeria",
            "Belgium",
            "Spain",
            "France",
            2
        )
        questionList.add(ques3)

        val ques4 = Question(
            4,
            "What Country does this flag belong now",
            R.drawable.ic_flag_of_brazil,
            "Moroco",
            "Netherland",
            "Brazil",
            "Japan",
            3
        )
        questionList.add(ques4)

        val ques5 = Question(
            5,
            "What Country does this flag belong now",
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Canada",
            "UAE",
            "India",
            1
        )
        questionList.add(ques5)

        val ques6 = Question(
            6,
            "What Country does this flag belong now",
            R.drawable.ic_flag_of_fiji,
            "Sri Lanka",
            "China",
            "South Korea",
            "Fiji",
            4
        )
        questionList.add(ques6)

        val ques7 = Question(
            7,
            "What Country does this flag belong now",
            R.drawable.ic_flag_of_germany,
            "China",
            "Japan",
            "Spain",
            "Germany",
            4
        )
        questionList.add(ques7)

        val ques8 = Question(
            8,
            "What Country does this flag belong now",
            R.drawable.ic_flag_of_india,
            "Thailand",
            "Malaysia",
            "India",
            "Japan",
            3
        )
        questionList.add(ques8)

        val ques9 = Question(
            9,
            "What Country does this flag belong now",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "Saudi Arabia",
            "Iran",
            "Iraq",
            1
        )
        questionList.add(ques9)

        val ques10 = Question(
            10,
            "What Country does this flag belong now",
            R.drawable.ic_flag_of_new_zealand,
            "Argentina",
            "New Zealand",
            "Australia",
            "USA",
            2
        )
        questionList.add(ques10)
        return questionList
    }
}