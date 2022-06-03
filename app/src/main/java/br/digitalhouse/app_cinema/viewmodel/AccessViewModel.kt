package br.digitalhouse.app_cinema.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.digitalhouse.app_cinema.model.UsuarioDataClass
import kotlinx.coroutines.launch

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