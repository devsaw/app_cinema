package br.digitalhouse.app_cinema.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.login.viewmodel.LoginViewModel

class TelaLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)
        botaoLogar()
    }

    fun botaoLogar(){
        var textSenhaLogar = findViewById<EditText>(R.id.editTextSenha)
        val senhaInformada = textSenhaLogar.text.toString()
        var textEmailLogar = findViewById<EditText>(R.id.editTextUsuario)
        val loginInformado = textEmailLogar.text.toString()
        var btnLogar = findViewById<ImageButton>(R.id.btnLogarLogin)
        var loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        btnLogar.setOnClickListener { loginViewModel.validaBotaoLogar("login", "senha") }
    }

}