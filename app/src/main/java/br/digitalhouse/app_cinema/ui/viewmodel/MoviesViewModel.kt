package br.digitalhouse.app_cinema.ui.viewmodel


import androidx.lifecycle.ViewModel
import br.digitalhouse.app_cinema.data.dto.Feed
import br.digitalhouse.app_cinema.data.dto.MoviesRepository
import br.digitalhouse.app_cinema.data.dto.Names

class MoviesViewModel: ViewModel() {
    val moviesRepository = MoviesRepository()

    suspend fun fetchPopular(page : Int = 1): Feed = moviesRepository.fetchPopular(page)

    suspend fun fetchMovies(search : String): Names = moviesRepository.fetchMovies(search)
}