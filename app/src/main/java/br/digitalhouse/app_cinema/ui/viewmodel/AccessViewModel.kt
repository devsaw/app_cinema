package br.digitalhouse.app_cinema.ui.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.digitalhouse.app_cinema.ui.model.UsuarioDataClass

class AccessViewModel() : ViewModel() {

    private val user = UsuarioDataClass("", "")
    private val mutableLiveDt = MutableLiveData<Boolean>()
    val requestLoginLiveData: LiveData<Boolean> = mutableLiveDt


    fun makeLogin(email: String, pass: String) {
        user.login = email
        user.senha = pass
        mutableLiveDt.value = user.verificaEmail(email) && user.verificaSenha(pass)
    }

}