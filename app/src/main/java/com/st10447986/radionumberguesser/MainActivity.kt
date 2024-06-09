package com.st10447986.radionumberguesser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var etLowerNumber : EditText? = null
    var etUpperNumber : EditText? = null
    var tvDisplay : TextView? = null
    var intLowerIndex : Int = 0
    var intUpperIndex: Int = 0
    var intMiddleIndex : Int = 0
    var intCount : Int = 0
    var arrNumbers = emptyArray<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etLowerNumber = findViewById(R.id.etLowerNumber)
        etUpperNumber = findViewById(R.id.etUpperNumber)
        tvDisplay = findViewById(R.id.tvDisplay)

        val btnBegin = findViewById<Button>(R.id.btnBegin)
        btnBegin.setOnClickListener{begin()}

        val btnLower = findViewById<Button>(R.id.btnLower)
        btnLower.setOnClickListener{lower()}

        val btnUpper = findViewById<Button>(R.id.btnUpper)
        btnUpper.setOnClickListener{upper()}
    }
    private fun begin(){
        val etLowerNumber = etLowerNumber?.text.toString().toInt()
        val etUpperNumber = etUpperNumber?.text.toString().toInt()

        for(i in etLowerNumber..etUpperNumber){
            arrNumbers[intCount] = i
            intCount += 1
        }
        setIndexes()
    }

    private fun lower(){
        intUpperIndex = intMiddleIndex - 1
        intMiddleIndex = (intLowerIndex + intUpperIndex) / 2
        tvDisplay?.text = "" + arrNumbers[intMiddleIndex]
    }

    private fun upper(){
        intLowerIndex = intMiddleIndex + 1
        intMiddleIndex = (intLowerIndex + intUpperIndex) / 2
        tvDisplay?.text = "" + arrNumbers[intMiddleIndex]
    }

    private fun setIndexes(){
        intLowerIndex = 0
        intUpperIndex = arrNumbers[intCount-1]
    }
}