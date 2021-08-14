package com.gunder.android_agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        inisialisasi
        val button = findViewById<Button>(R.id.btnAdd)
        button.setOnClickListener { view ->
            printAge(view)
        }
    }

    private fun printAge(view: View) {
//        mendapatkan instance dari kalendar
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this
        ,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                val selecetDate = "$day/${month+1}/$year"
                val textView = findViewById<TextView>(R.id.tvbod)
                textView.text = selecetDate
                val dob = Calendar.getInstance()
                dob.set(year,month,day)
                var age = calendar.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
                if (calendar.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
                    age--
                }
                val tvresult = findViewById<TextView>(R.id.tvresult)
                tvresult.text = "usia kamu $age tahun" }
        ,year
        ,month
        ,day).show()
    }
}