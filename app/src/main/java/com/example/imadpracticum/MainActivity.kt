package com.example.imadpracticum

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()// Enable edge-to-edge display on supported devices
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.buttonHome) // Finding the "Home" button in the layout and assigning it to a variable
        button.setOnClickListener { // Setting a click listener for the "Home" button
            val intent = Intent(this, HomeActivity::class.java)// Creating an Intent to start the HomeActivity
            startActivity(intent) // Starting the HomeActivity
        }
    }
}