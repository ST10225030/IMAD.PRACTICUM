package com.example.imadpracticum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout for this activity
        setContentView(R.layout.activity_splash)

        // Find the "Enter" button in the layout and set a click listener
        findViewById<Button>(R.id.buttonEnter).setOnClickListener {

            // When the "Enter" button is clicked, start the MainActivity and finish this activity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        // Find the "Exit" button in the layout and set a click listener
        findViewById<Button>(R.id.buttonExit).setOnClickListener {

            // When the "Exit" button is clicked, finish this activity
            finish()
        }
    }
}
