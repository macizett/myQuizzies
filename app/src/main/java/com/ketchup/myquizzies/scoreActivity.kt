package com.ketchup.myquizzies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class scoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)


        var scoreView: TextView = findViewById(R.id.scoreView)
        var backButton: Button = findViewById(R.id.backButton)

        var text = UsernameStore.score.toString()
        scoreView.setText("$text/${UsernameStore.maxQuestions}")

        backButton.setOnClickListener{
            val MineActivity = Intent(this, MainActivity::class.java)
            startActivity(MineActivity)
            finish()
        }
    }
}