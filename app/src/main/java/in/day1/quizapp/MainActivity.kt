package `in`.day1.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_Start : Button = findViewById(R.id.btn_start)
        // variable attached to the button
        val inputText : EditText= findViewById(R.id.inputText)
        // variable attached to the Edit text window for input of name
        btn_Start.setOnClickListener{
            if(inputText.text.isEmpty() ) {
                // If there is nothing entered in the edit text then show the toast message
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_LONG).show()
            }
            else {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.userName, inputText.text.toString())
                // set the intent to which new activity we should move on to in variable intent
                startActivity(intent)
                // starts the new activity where as previous one remains
                finish()
                // closes the current activity
            }
        }
    }
}