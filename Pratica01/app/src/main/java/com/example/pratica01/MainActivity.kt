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
    private lateinit var btnpalpite: Button
    private lateinit var sorteio: Sorteio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //atribuindo os componentes da view para variaveis
        this.tvMaiorValor = findViewById(R.id.tvMaiorValor)
        this.tvMenorValor = findViewById(R.id.tvMenorValor)
        this.tvStatus = findViewById(R.id.tvStatus)
        this.textInputChute = findViewById(R.id.textInputChute)
        this.btnpalpite = findViewById(R.id.btnChute)

        //realiza o sorteio do valor
        this.sorteio = Sorteio()

        //atualiza os valores min e max na view
        this.tvMenorValor.text = sorteio.getValorMin().toString()
        this.tvMaiorValor.text = sorteio.getValorMax().toString()


        //realiza o chute
        this.btnpalpite.setOnClickListener { onClickChute(it) }

        //realiza outro sorteio
        this.tvStatus.setOnLongClickListener  {
            onClickSortear(it)
            true
        }
    }

    fun onClickChute(view: View) {
        var chute = this.textInputChute.text.toString().toInt()

        this.tvStatus.text = sorteio.chute(chute)

        //atualiza os valores min e max na view
        this.tvMaiorValor.text = sorteio.getValorMax().toString()
        this.tvMenorValor.text = sorteio.getValorMin().toString()
    }

    fun onClickSortear(view: View){
        this.sorteio = Sorteio()

        //atualiza os valores min e max na view
        this.tvMenorValor.text = sorteio.getValorMin().toString()
        this.tvMaiorValor.text = sorteio.getValorMax().toString()
        this.tvStatus.text = ""
    }
}