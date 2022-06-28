package br.digitalhouse.app_cinema.data.dto


import retrofit2.http.GET


interface MoviesInterface {
    @GET("movie/popular?api_key=${API_KEY}&language=pt-BR&page=1")
    suspend fun fetchPopular(): Feed


    @GET("search/movie?query=velozes&api_key=${API_KEY}&language=pt-BR")
    suspend fun fetchMovies(): Names
}