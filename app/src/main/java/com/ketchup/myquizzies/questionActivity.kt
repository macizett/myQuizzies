package com.ketchup.myquizzies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import java.util.Random

class questionActivity : AppCompatActivity() {
    val store = UsernameStore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        var nameDisplay: TextView = findViewById(R.id.nameDisplay)
        var questionsTextView: TextView = findViewById(R.id.questionsTextView)
        var scoreTextView: TextView = findViewById(R.id.scoreTextView)
        var buttonA: Button = findViewById(R.id.answerAButton)
        var buttonB: Button = findViewById(R.id.answerBButton)
        var buttonC: Button = findViewById(R.id.answerCButton)
        var buttonD: Button = findViewById(R.id.answerDButton)
        var buttonSubmit: Button = findViewById(R.id.submitButton)
        var flagView: ImageView = findViewById(R.id.imageView)
        var name2 = store.username
        nameDisplay.setText("Hello, $name2!")
        UsernameStore.score = 0
        UsernameStore.questionsCount = 0

        fun Question() {
            scoreTextView.setText("${UsernameStore.score}/${UsernameStore.maxQuestions}")
            questionsTextView.setText("${UsernameStore.questionsCount}/${UsernameStore.maxQuestions}")
            var random = Random()

            fun rand(from: Int, to: Int): Int {
                return random.nextInt(to - from) + from
            }
            var randomCountry = rand(0, 196)
            var buttons = arrayListOf(buttonA, buttonB, buttonC, buttonD)
            var button = buttons.shuffled()
            var button0 = button[0]
            var button1 = button[1]
            var button2 = button[2]
            var button3 = button[3]
            var country = questions.country[randomCountry]
            var countryWrong = questions.country[randomCountry]
            var flag = questions.flag[randomCountry]

            var checkIfAnswered = UsernameStore.questionsCount

            button0.setText(country)
            flagView.setImageResource(flag)
            var shuffledCountries = questions.country.shuffled()
            var listOfWrongCountries = shuffledCountries.minusElement(button0.text)
            button1.setText(listOfWrongCountries[114])
            button2.setText(listOfWrongCountries[58])
            button3.setText(listOfWrongCountries[7])

            button0.background = ContextCompat.getDrawable(this, R.drawable.default_button_background)
            button1.background = ContextCompat.getDrawable(this, R.drawable.default_button_background)
            button2.background = ContextCompat.getDrawable(this, R.drawable.default_button_background)
            button3.background = ContextCompat.getDrawable(this, R.drawable.default_button_background)


            button0.setOnClickListener {
                UsernameStore.score = UsernameStore.score + 1
                UsernameStore.questionsCount = UsernameStore.questionsCount + 1
                nameDisplay.setText("")
                button0.background = ContextCompat.getDrawable(this, R.drawable.right_answer_button_background)
            }
            button1.setOnClickListener {
                UsernameStore.questionsCount = UsernameStore.questionsCount + 1
                nameDisplay.setText("")
                button0.background = ContextCompat.getDrawable(this, R.drawable.right_answer_button_background)
                button1.background = ContextCompat.getDrawable(this, R.drawable.wrong_answer_button_background)
            }
            button2.setOnClickListener {
                UsernameStore.questionsCount = UsernameStore.questionsCount + 1
                nameDisplay.setText("")
                button0.background = ContextCompat.getDrawable(this, R.drawable.right_answer_button_background)
                button2.background = ContextCompat.getDrawable(this, R.drawable.wrong_answer_button_background)
            }
            button3.setOnClickListener {
                UsernameStore.questionsCount = UsernameStore.questionsCount + 1
                nameDisplay.setText("")
                button0.background = ContextCompat.getDrawable(this, R.drawable.right_answer_button_background)
                button3.background = ContextCompat.getDrawable(this, R.drawable.wrong_answer_button_background)
            }

            buttonSubmit.setOnClickListener {
                Toast.makeText(this, "The good answer was: $country", Toast.LENGTH_SHORT).show()
                if (checkIfAnswered == UsernameStore.questionsCount + 1) {
                    if (UsernameStore.questionsCount < UsernameStore.maxQuestions) {
                        Question()
                    } else {
                        val scoreScreen = Intent(this, scoreActivity::class.java)
                        startActivity(scoreScreen)
                        finish()
                        // LAST ACTIVITY
                    }
                }
                else {
                    Toast.makeText(this, "Please choose an answer!!!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        Question()

    }
}