package com.example.pratica02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var tvMenorValor: TextView
    private lateinit var tvMaiorValor: TextView
    private lateinit var tvStatus: TextView
    private lateinit var textInputChute: TextView
    private lateinit var btnChute: Button
    private lateinit var sorteio: Sorteio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //atribuindo os componentes da view para variaveis
        this.tvMaiorValor = findViewById(R.id.tvMaiorValor)
        this.tvMenorValor = findViewById(R.id.tvMenorValor)
        this.tvStatus = findViewById(R.id.tvStatus)
        this.textInputChute = findViewById(R.id.textInputChute)
        this.btnChute = findViewById(R.id.btnChute)

        //definindo contrato generico
        val outroResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val msg = it.data?.getStringExtra("MSG_VOLTA")
                this.tvStatus.text = "Pressione para jogar novamente ${msg}."
                //Toast.makeText(this, it.data?.getStringExtra("MSG_VOLTA"), Toast.LENGTH_SHORT).show()
            }
        }

        //realiza o sorteio do valor
        this.sorteio = Sorteio()

        //atualiza os valores min e max na view
        this.tvMenorValor.text = sorteio.getValorMin().toString()
        this.tvMaiorValor.text = sorteio.getValorMax().toString()

        //realiza o chute
        this.btnChute.setOnClickListener{
            val main = this@MainActivity

            var chute = main.textInputChute.text.toString().toInt()

            main.tvStatus.text = sorteio.chute(chute)

            if(this.tvStatus.text == "ganhou" || this.tvStatus.text == "perdeu") {

                val msg = this.tvStatus.text.toString()
                val intent = Intent(this@MainActivity, OutraActivity:: class.java).apply {
                    putExtra("MSG_IDA", msg)
                }

                outroResult.launch(intent)
            }

            // atualiza os valores min e max na view
            main.tvMaiorValor.text = sorteio.getValorMax().toString()
            main.tvMenorValor.text = sorteio.getValorMin().toString()
        }

        //realiza outro sorteio
        this.tvStatus.setOnLongClickListener  {
            onClickSortear(it)
            true
        }
    }

    inner class ClickChute: View.OnClickListener {
        override fun onClick(v: View?) {
            val main = this@MainActivity

            var chute = main.textInputChute.text.toString().toInt()

            main.tvStatus.text = sorteio.chute(chute)

            // atualiza os valores min e max na view
            main.tvMaiorValor.text = sorteio.getValorMax().toString()
            main.tvMenorValor.text = sorteio.getValorMin().toString()

        }
    }

    fun onClickSortear(view: View){
        this.sorteio = Sorteio()

        //atualiza os valores min e max na view
        this.tvMenorValor.text = sorteio.getValorMin().toString()
        this.tvMaiorValor.text = sorteio.getValorMax().toString()
        this.tvStatus.text = ""
    }
}