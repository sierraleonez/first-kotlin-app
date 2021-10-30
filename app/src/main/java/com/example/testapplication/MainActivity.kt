package com.example.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        private const val STATE_RESULT = "state_result"
    }
    private lateinit var edtWidth : EditText
    private lateinit var edtHeight : EditText
    private lateinit var edtLength : EditText
    private lateinit var btnCalculate : Button
    private lateinit var tvResult : TextView

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        println("======== onSaveInstanceState")
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.edit_wide)
        edtHeight = findViewById(R.id.edit_height)
        edtLength = findViewById(R.id.edit_length)
        btnCalculate = findViewById(R.id.button_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        println(savedInstanceState?.getString(STATE_RESULT)?:"null")
        if(savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }

     override fun onClick(v : View){
        if(v.id == R.id.button_calculate){
            val inputLength = edtLength.text.toString().trim()
            val inputWIdth = edtWidth.text.toString().trim()
            val inputHeight: String = edtHeight.text.toString().trim()
            var isEmpty = false

            if(inputLength.isEmpty()){
                isEmpty = true
                edtLength.error = "Field ini tidak boleh kosong"
            }
            if(inputWIdth.isEmpty()){
                isEmpty = true
                edtWidth.error = "Field ini tidak boleh kosong"
            }
            if(inputHeight.isEmpty()){
                isEmpty = true
                edtHeight.error = "Field ini tidak boleh kosong"
            }

            if(!isEmpty){
            val volume = inputLength.toDouble() * inputWIdth.toDouble() * inputHeight.toDouble()
            println(volume.toString())
            tvResult.text = volume.toString()
            }
        }
    }
}




