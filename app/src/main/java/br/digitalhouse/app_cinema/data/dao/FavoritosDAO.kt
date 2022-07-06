package br.digitalhouse.app_cinema.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.digitalhouse.app_cinema.data.Favoritos

@Dao
interface FavoritosDAO {
    @Query("SELECT * FROM favoritos")
    fun getAll(): List<Favoritos>

    @Insert
    fun insert(filmesFavoritos: Favoritos)

    @Delete
    fun delete(filmesFavoritos: Favoritos)
}