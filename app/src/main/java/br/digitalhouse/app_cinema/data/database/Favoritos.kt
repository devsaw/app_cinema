package br.digitalhouse.app_cinema.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favoritos(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo var title: String,
    @ColumnInfo var imagemfilmes: String
    )
