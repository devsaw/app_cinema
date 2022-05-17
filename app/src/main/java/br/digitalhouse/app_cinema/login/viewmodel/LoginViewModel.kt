package br.digitalhouse.app_cinema.login.viewmodel

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.digitalhouse.app_cinema.login.model.UsuarioDataClass
import br.digitalhouse.app_cinema.principal.view.TelaPrincipalActivity

class LoginViewModel : ViewModel() {

    private val user = UsuarioDataClass("", "")
    private val mutableLiveDt = MutableLiveData<String>()
    val requestLoginLiveData: LiveData<String> = mutableLiveDt

    fun logarUsuario(login: String, senha: String, context: Context) {
        user.senha = senha
        user.login = login
        mutableLiveDt.value = validarLogin(context).toString()
    }

    fun validarLogin(context: Context) {
        if (user.login.isBlank() || user.senha.isBlank()) {
            Toast.makeText(context, "Preencha os campos", Toast.LENGTH_SHORT).show()
        } else {
            if (user.validaSenha("") && user.validaEmail("")) {
                Toast.makeText(context, "Logado!", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, TelaPrincipalActivity::class.java)
                context.startActivity(intent)
            } else {
                Toast.makeText(context, "Dados incorretos", Toast.LENGTH_SHORT).show()

            }
        }
    }

}