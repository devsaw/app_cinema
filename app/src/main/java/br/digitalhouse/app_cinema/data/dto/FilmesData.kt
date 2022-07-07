package br.digitalhouse.app_cinema.data.dto

import com.google.gson.annotations.SerializedName

data class Feed(
    @SerializedName("results")
    val populares: List<Popular>,
)

data class Popular(
    val title: String,

    @SerializedName("poster_path")
    val filmes: String,

    val overview: String,
)




data class Names(@SerializedName("results") val names: List<Resultados>)

data class Resultados(
    @SerializedName("title")
    val pesquisados: String,

    @SerializedName("poster_path")
    val fotos: String,
)