package `in`.day1.quizapp

data class Question(
    val id: Int,
    val Ques: String,
    val image: Int, // kotlin loads an images as an integer
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAns: Int // 1, 2, 3, 4
)
