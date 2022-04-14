package br.digitalhouse.app_cinema.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.data.Usuario

class TelaLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)
        botaoLogar()
        botaoEsqueciSenha()
    }



    fun botaoLogar(){
        var btnLogar = findViewById<Button>(R.id.btnLogarLogin)
        btnLogar.setOnClickListener { validaBotaoLogar() }
    }

    fun botaoEsqueciSenha(){
        var btnEsqueciSenha = findViewById<Button>(R.id.btnEsqueciSenhaLogin)
        btnEsqueciSenha.setOnClickListener { intencaoTelaRecuperarSenha() }
    }

    fun validaBotaoLogar() {
        var textSenhaLogar = findViewById<EditText>(R.id.editTextSenha)
        val senhaInformada = textSenhaLogar.text.toString()
        var textEmailLogar = findViewById<EditText>(R.id.editTextUsuario)
        val loginInformado = textEmailLogar.text.toString()

        val usuario = Usuario(loginInformado, senhaInformada)
        val validaEmail: Boolean = usuario.validaEmail(loginInformado)
        val validacao: Boolean = usuario.validaSenha(senhaInformada)
        if (textEmailLogar.text.isNullOrBlank() || textSenhaLogar.text.isNullOrBlank()) {
            Toast.makeText(this, "Preencha os campos", Toast.LENGTH_SHORT).show()
        } else {
            if (validacao && validaEmail) {
                Toast.makeText(this, "${textEmailLogar.text} Logado!", Toast.LENGTH_SHORT).show()
                var intent2 = Intent(this, TelaPrincipal::class.java)
                startActivity(intent2)
            } else {
                Toast.makeText(this, "Dados incorretos", Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun intencaoTelaRecuperarSenha(){
        var intent3 = Intent(this, TelaRecuperarSenha::class.java)
        startActivity(intent3)
    }
}