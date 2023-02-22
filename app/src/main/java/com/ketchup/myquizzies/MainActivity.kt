package com.ketchup.myquizzies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var nameVar: String = "name"
        var goButton: Button = findViewById(R.id.goButton)
        var questions10: RadioButton = findViewById(R.id.questions10)
        var questions50: RadioButton = findViewById(R.id.questions50)
        var questions100: RadioButton = findViewById(R.id.questions100)
        var txtInput: EditText = findViewById(R.id.txtInput)
        var txtView: TextView = findViewById(R.id.textView)
        var maxQuestionsBool: Boolean = false

        questions10.setOnClickListener{
            UsernameStore.maxQuestions = 10
            maxQuestionsBool = true
        }

        questions50.setOnClickListener{
            UsernameStore.maxQuestions = 50
            maxQuestionsBool = true
        }

        questions100.setOnClickListener{
            UsernameStore.maxQuestions = 100
            maxQuestionsBool = true
        }

        goButton.setOnClickListener{
            if (txtInput.text.isEmpty()) {
                Toast.makeText(this, "Please enter Your name!", Toast.LENGTH_SHORT).show()
            }
            else{
                nameVar = txtInput.text.toString()
                    if (maxQuestionsBool == false){
                        Toast.makeText(this, "Please choose amount of Questions!!!", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(this, "Hello, $nameVar!", Toast.LENGTH_SHORT).show()
                        var name = UsernameStore
                        name.username = nameVar
                        val questionScreen = Intent(this, questionActivity::class.java)
                        startActivity(questionScreen)
                        finish()
                    }
            }
        }
    }
}