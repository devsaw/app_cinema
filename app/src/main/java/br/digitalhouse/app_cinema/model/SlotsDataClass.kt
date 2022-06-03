package br.digitalhouse.app_cinema.model

data class SlotsDataClass(
    val slotImage: Int, val text: String, val movieList: List<MovieDataClass>,)
