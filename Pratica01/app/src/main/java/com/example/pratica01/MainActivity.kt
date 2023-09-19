package com.example.pratica01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvMenorValor: TextView
    private lateinit var tvMaiorValor: TextView
    private lateinit var tvStatus: TextView
    private lateinit var textInputChute: TextView
    private lateinit var btnChute: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //atribuindo valores
        this.tvMaiorValor = findViewById(R.id.tvMaiorValor)
        this.tvMenorValor = findViewById(R.id.tvMenorValor)
        this.tvStatus = findViewById(R.id.tvStatus)
        this.textInputChute = findViewById(R.id.textInputChute)
        this.btnChute = findViewById(R.id.btnChute)

        //realiza o sorteio do valor
        val sorteio = Sorteio()

        this.tvMenorValor.text = sorteio.getValorMin().toString()
        this.tvMaiorValor.text = sorteio.getValorMax().toString()
        var tvChute = this.textInputChute.text.toString()

        //realiza o chute
        this.btnChute.setOnClickListener { onClickChute(it, sorteio, tvChute) }
    }

    fun onClickChute(view: View, sorteio: Sorteio, tvChute: String){
        this.tvStatus.text = sorteio.chute(tvChute.toInt())
        this.tvMenorValor.text = sorteio.getValorMin().toString()
        this.tvMaiorValor.text = sorteio.getValorMax().toString()
    }
}