package br.digitalhouse.app_cinema.data.database.dao

import androidx.room.*
import br.digitalhouse.app_cinema.data.database.Favoritos

@Dao
interface FavoritosDAO {

    @Query("SELECT * FROM favoritos")
    suspend fun getAll(): MutableList<Favoritos>

    @Insert()
    suspend fun insert(filmesFavoritos: Favoritos)
    //onConflict = OnConflictStrategy.REPLACE

    @Delete
    fun delete(filmesFavoritos: Favoritos)

}