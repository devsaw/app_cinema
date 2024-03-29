package br.digitalhouse.app_cinema.ui.viewmodel

import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.viewModelScope
import br.digitalhouse.app_cinema.data.database.Favoritos
import br.digitalhouse.app_cinema.data.database.dao.FavoritosRepository
import kotlinx.coroutines.launch

class FavoritosViewModel(application: Application) : AndroidViewModel(application) {

    var getFavoritos = MutableLiveData<List<Favoritos>>()
    var getFavoritosLiveData: LiveData<List<Favoritos>> = getFavoritos

    private val favoritosRepository: FavoritosRepository by lazy {
        FavoritosRepository(application)
    }

    fun saveFavorite(favoritos: Favoritos) =
        viewModelScope.launch {
            favoritosRepository.insertFavorite(favoritos)
            //livedata observer

        }

    fun getSaveFavorite() =
        viewModelScope.launch {
            getFavoritos.value = favoritosRepository.getAll()
        }

    fun deleteFavoritos(favoritos: Favoritos) =
        viewModelScope.launch {
            favoritosRepository.delete(favoritos)
        }



    fun updateFavoritos(favoritos: Favoritos) {
        viewModelScope.launch {
                favoritosRepository.update(favoritos)
            }

    }
}

