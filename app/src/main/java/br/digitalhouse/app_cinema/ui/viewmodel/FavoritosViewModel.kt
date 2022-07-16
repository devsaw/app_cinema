package br.digitalhouse.app_cinema.ui.viewmodel

import android.app.Application

import android.content.Context
import androidx.lifecycle.AndroidViewModel

import androidx.lifecycle.viewModelScope
import br.digitalhouse.app_cinema.data.database.Favoritos
import br.digitalhouse.app_cinema.data.database.dao.FavoritosRepository
import kotlinx.coroutines.launch

class FavoritosViewModel(application: Application): AndroidViewModel(application) {

    private val favoritosRepository: FavoritosRepository by lazy {
        FavoritosRepository(application)
    }


    fun salveFavorite(favoritos: Favoritos) =
        viewModelScope.launch {
            favoritosRepository.saveFavorite(favoritos)
            //livedata observer

        }


    fun getSalveFavorite() =
        viewModelScope.launch {
            favoritosRepository.getAll()
        }

    fun deleteFavoritos(favoritos: Favoritos) =
        viewModelScope.launch {
            favoritosRepository.delete(favoritos)
        }
}

