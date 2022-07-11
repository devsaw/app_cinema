package br.digitalhouse.app_cinema.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import br.digitalhouse.app_cinema.data.database.Favoritos

@Dao
interface FavoritosDAO {

    @Query("SELECT * FROM favoritos")
    suspend fun getAll(): List<Favoritos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(filmesFavoritos: Favoritos)

    @Delete
    fun delete(filmesFavoritos: Favoritos)
}