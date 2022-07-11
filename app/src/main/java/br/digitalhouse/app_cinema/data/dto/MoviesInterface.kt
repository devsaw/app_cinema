package br.digitalhouse.app_cinema.data.dto

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryName

interface MoviesInterface {
    @GET("movie/popular?api_key=${API_KEY}&language=pt-BR")
    suspend fun fetchPopular(
        @Query("page") page: Int
    ): Feed


    @GET("search/movie?api_key=${API_KEY}&language=pt-BR")
    suspend fun fetchMovies(
        @Query("query") search: String
    ): Names
}