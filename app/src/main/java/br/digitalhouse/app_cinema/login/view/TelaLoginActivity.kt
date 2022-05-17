package br.digitalhouse.app_cinema.login.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.login.viewmodel.LoginViewModel

class TelaLoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        botaoLogar(this)
        observer()
    }

    fun botaoLogar(context : Context){
        var senha = findViewById<EditText>(R.id.editTextSenha).text.toString()
        var login = findViewById<EditText>(R.id.editTextUsuario).text.toString()
        var btnLogar = findViewById<ImageButton>(R.id.btnLogarLogin)
        btnLogar.setOnClickListener { loginViewModel.logarUsuario(login, senha, context)}
    }

    private fun observer(){
        loginViewModel.requestLoginLiveData.observe(this) { it }
    }

}