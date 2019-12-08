package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculateButton : Button = findViewById(R.id.buttonCalculate)
        val resetButton : Button = findViewById(R.id.buttonReset)

        calculateButton.setOnClickListener{ calculateBMI() }
        resetButton.setOnClickListener { resetBMI() }
    }

    private fun calculateBMI(){
        val heightInput: EditText = findViewById(R.id.editTextHeight)
        val weightInput: EditText = findViewById(R.id.editTextWeight)
        val resultImage: ImageView = findViewById(R.id.imageViewProfile)
        val setResult: TextView  = findViewById(R.id.textViewBMI)
        val heightDouble: Double = heightInput.text.toString().toDouble() / 100
        val weightDouble: Double = weightInput.text.toString().toDouble()
        val result: Double =  weightDouble / (heightDouble * heightDouble)

        resultImage.setImageResource(R.drawable.empty)

        if (result < 18.5){
            resultImage.setImageResource(R.drawable.under)
        } else if (result >= 18.5 && result <= 24.9){
            resultImage.setImageResource(R.drawable.normal)
        } else if (result >= 25){
            resultImage.setImageResource(R.drawable.over)
        }

        setResult.setText("BMI : "+result)
    }

    private fun resetBMI(){
        val heightInput: EditText = findViewById(R.id.editTextHeight)
        val weightInput: EditText = findViewById(R.id.editTextWeight)
        val resultImage: ImageView = findViewById(R.id.imageViewProfile)
        val setResult: TextView  = findViewById(R.id.textViewBMI)
        resultImage.setImageResource(R.drawable.empty)
        setResult.setText("BMI : ")
        heightInput.setText("")
        weightInput.setText("")

    }
}