package com.example.pratica02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import org.w3c.dom.Text

class OutraActivity : AppCompatActivity() {

    private lateinit var meuBtn: Button
    private lateinit var tvOutra: TextView
    private lateinit var inputTV: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outra)

        //atribuindo os componentes da view para variaveis
        this.meuBtn = findViewById(R.id.meubtn)
        this.tvOutra = findViewById(R.id.textView2)
        this.inputTV = findViewById(R.id.nomeInput)

        if(intent.hasExtra("MSG_IDA")) {
            val msg = intent.getStringExtra("MSG_IDA")

            this.tvOutra.text = "Você ${msg}. Digite seu nome para jogar novamente."
            //Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        this.meuBtn.setOnClickListener{

            val msg = this.inputTV.text.toString()
            val intent = Intent().apply {
                putExtra("MSG_VOLTA", msg)
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }

}