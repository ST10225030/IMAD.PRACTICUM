package com.example.imadpracticum

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class HomeActivity : AppCompatActivity() {

    // Declaring EditText variables to store user input
    private lateinit var etDate: EditText
    private lateinit var etMorning: EditText
    private lateinit var etAfternoon: EditText
    private lateinit var etNotes: EditText
    private val screenTimeData = ArrayList<ScreenTimeEntry>()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        etDate = findViewById(R.id.listView)
        etMorning = findViewById(R.id.average_info)
        etAfternoon = findViewById(R.id.etAfternoon)
        etNotes = findViewById(R.id.etNotes)
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        val buttonClear = findViewById<Button>(R.id.buttonClear)
        val buttonNext = findViewById<Button>(R.id.buttonBack)

        buttonSave.setOnClickListener {
            saveData()
        }

        buttonClear.setOnClickListener {
            clearData()
        }

        buttonNext.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java)
            intent.putParcelableArrayListExtra("data", screenTimeData)
            startActivity(intent)
        }
    }


    // Function to save user input data
    private fun saveData() {
        val date = etDate.text.toString()
        val morning = etMorning.text.toString()
        val afternoon = etAfternoon.text.toString()
        val notes = etNotes.text.toString()

        // Check if any of the fields are empty
        if (date.isEmpty() || morning.isEmpty() || afternoon.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }


        // Create a ScreenTimeEntry object and add it to the ArrayList
        val entry = ScreenTimeEntry(date, morning.toDouble(), afternoon.toDouble(), notes)
        screenTimeData.add(entry)

        // Display a toast message to indicate successful data saving
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
    }

    // Function to clear all user input data
    private fun clearData() {
        etDate.text.clear()
        etMorning.text.clear()
        etAfternoon.text.clear()
        etNotes.text.clear()

        // Display a toast message to indicate successful data clearing
        Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show()
    }
}
