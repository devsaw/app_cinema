package br.digitalhouse.app_cinema.data.dto

import br.digitalhouse.app_cinema.data.filmesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepository {
    private val api = filmesApi

    suspend fun fetchPopular(page : Int): Feed = withContext(Dispatchers.IO){
        api.fetchPopular(page)
    }

    suspend fun fetchMovies(): Names = withContext(Dispatchers.IO){
        api.fetchMovies()
    }

}
