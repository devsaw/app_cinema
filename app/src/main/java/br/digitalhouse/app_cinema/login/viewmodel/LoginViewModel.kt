package br.digitalhouse.app_cinema.login.viewmodel

import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import br.digitalhouse.app_cinema.login.model.UsuarioDataClass
import br.digitalhouse.app_cinema.principal.view.TelaPrincipalActivity

class LoginViewModel : ViewModel() {

    fun validaEmail(login: String): Boolean {
        var variavel = false
        if (login.contains("@"))
            variavel = true
        return variavel
    }

    
    fun validaTamanho(senha: String): Boolean {
        return senha.count() >= 8
    }


    fun validaEspeciais(senha: String): Boolean {
        val listaEspeciais: List<String> =
            listOf("!", "@", "#", "$", "¨", "&", "*", "(", ")", "'", "-", "=", "+", "_", ".", ",", "/", "%", ":", ";", "?")
        var variavel = false
        for (character in listaEspeciais)
            if (senha.contains(character))
                variavel = true
        return variavel
    }


    fun validaNumeros(senha: String): Boolean {
        val listaNumeros: List<String> =
            listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")
        var variavel = false
        for (character in listaNumeros)
            if (senha.contains(character))
                variavel = true
        return variavel
    }


    fun validacaoSenha(senha: String): Boolean {
        val variavelEspeciais: Boolean = validaEspeciais(senha)
        val variavelNumeros: Boolean = validaNumeros(senha)
        val variavelTamanho: Boolean = validaTamanho(senha)
        var variavel = false
        if ((variavelEspeciais && variavelNumeros && variavelTamanho))
            variavel = true
        return variavel
    }


    fun validaBotaoLogar(login: String, senha: String): Boolean {
        val validaEmail: Boolean = validaEmail(loginInformado)
        val validaSenha: Boolean = validacaoSenha(senhaInformada)
        if (textEmailLogar.text.isNullOrBlank() || textSenhaLogar.text.isNullOrBlank()) {
            Toast.makeText(this, "Preencha os campos", Toast.LENGTH_SHORT).show()
        } else {
            if (validaSenha && validaEmail) {
                Toast.makeText(this, "${textEmailLogar.text} Logado!", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, TelaPrincipalActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Dados incorretos", Toast.LENGTH_SHORT).show()

            }
        }
    }

}