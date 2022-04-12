package br.digitalhouse.app_cinema.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.digitalhouse.app_cinema.R

class TelaInicial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        var btnInicialLogar = findViewById<Button>(R.id.btnLogarInicial)
        btnInicialLogar.setOnClickListener {
            intencaoTelaLogin()
        }

        var btnInicialCriar = findViewById<Button>(R.id.btnCriarContaInicial)
        btnInicialCriar.setOnClickListener {
            intencaoTelaCriarConta()
        }
    }


    fun intencaoTelaLogin() {
        var intent1 = Intent(this, TelaLogin::class.java)
        startActivity(intent1)
    }

    fun intencaoTelaCriarConta() {
        var intent2 = Intent(this, TelaCriarConta::class.java)
        startActivity(intent2)
    }
}