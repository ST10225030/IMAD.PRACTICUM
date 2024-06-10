package com.example.imadpracticum

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.example.imadpracticum.R

class DetailedViewActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)


        val data = intent.getParcelableArrayListExtra<ScreenTimeEntry>("data") ?: arrayListOf()
        val listView = findViewById<ListView>(R.id.listView)
        val averageTextView = findViewById<TextView>(R.id.average_info)
        val btnBack = findViewById<Button>(R.id.buttonBack)

        // Calculate averages
        var totalMorning = 0.0
        var totalAfternoon = 0.0
        data.forEach {
            totalMorning += it.morning
            totalAfternoon += it.afternoon
        }
        val averageMorning = if (data.isNotEmpty()) totalMorning / data.size else 0.0
        val averageAfternoon = if (data.isNotEmpty()) totalAfternoon / data.size else 0.0
        averageTextView.text = "Average Morning: $averageMorning\nAverage Afternoon: $averageAfternoon"

        // Populate ListView
        val detailedInfoList = data.map { "Date: ${it.date}\nMorning: ${it.morning}\nAfternoon: ${it.afternoon}\nNotes: ${it.notes}" }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, detailedInfoList)
        listView.adapter = adapter

        btnBack.setOnClickListener {
            finish()
        }
    }


}
