package com.example.kalkulator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

@Suppress("IMPLICIT_CAST_TO_ANY")
class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1EditText = findViewById<EditText>(R.id.num1EditText)
        val num2EditText = findViewById<EditText>(R.id.num2EditText)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val wynikTxt = findViewById<TextView>(R.id.wynikTxt)
        val obliczBtn: Button = findViewById(R.id.obliczBtn)

        val operacje = listOf<String>("Dodawanie", "Odejmowanie", "Mnożenie", "Dzielenie")

        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, operacje)
        spinner.adapter = adapterSpinner

        obliczBtn.setOnClickListener {
            val liczba1 = num1EditText.text.toString().toDoubleOrNull()
            val liczba2 = num2EditText.text.toString().toDoubleOrNull()
            val operation = spinner.selectedItem.toString()

            if (liczba1 != null && liczba2 != null) {
                val wynik = when (operation) {
                    "Dodawanie" -> liczba1 + liczba2
                    "Odejmowanie" -> liczba1 - liczba2
                    "Mnożenie" -> liczba1 * liczba2
                    "Dzielenie" -> {
                        if (liczba2 != 0.0) liczba1 / liczba2 else {
                            wynikTxt.text = "Nie można dzielić przez zero"
                        }
                    }
                    else -> 0.0
                }
                wynikTxt.text = "Wynik: $wynik"
            } else {
                wynikTxt.text = "Nieprawidłowe dane"
            }
        }
    }
}