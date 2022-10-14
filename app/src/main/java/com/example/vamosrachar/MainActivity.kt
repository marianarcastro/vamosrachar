package com.example.vamosrachar

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextTextPersonName: EditText = findViewById(R.id.editTextTextPersonName)
        val editTextTextPersonName2: EditText = findViewById(R.id.editTextTextPersonName2)

        var textView5: TextView = findViewById(R.id.textView5)

        var valorTotal: String = ""
        var qntPessoas: String = ""

        val button = findViewById(R.id.button) as Button

        button!!.setOnClickListener { TTS(this@MainActivity, textView5.text.toString()) }

        editTextTextPersonName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                valorTotal = s.toString()
            }
        })

        editTextTextPersonName2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                qntPessoas = s.toString()
                if(valorTotal != null && valorTotal != "" && qntPessoas != null && qntPessoas != "") {
                    textView5.setText("${calculateAccount(valorTotal, qntPessoas)}")
                }
            }
        })
    }

    private fun calculateAccount(valorTotal: String, qntPessoas: String):Float {
        return valorTotal.toFloat()/qntPessoas.toInt()
    }

}