package br.digitalhouse.app_cinema.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favoritos(

    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "primeira_informacao") val primeirainformacao: String?,
    @ColumnInfo(name = "segunda_informacao") val segundainformacao: String?

//Editar nomes de acordo com o projeto
    )
