package com.example.pratica02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textViewMensagem: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.textViewMensagem = findViewById(R.id.tvMensagem)

        this.textViewMensagem.text = Aposta().toString()
    }
}