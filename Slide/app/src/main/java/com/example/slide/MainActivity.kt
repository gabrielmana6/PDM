package com.example.slide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textViewMensagem: TextView
    private lateinit var btNova: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.textViewMensagem = findViewById(R.id.tvMensagem)

        this.textViewMensagem.text = Aposta().toString()

        this.btNova = findViewById(R.id.btnNova)
        this.btNova.setOnClickListener { onClickMetodo01(it) }
    }

    fun onClickMetodo01(view: View){
        this.textViewMensagem.text = Aposta().toString()
    }
}