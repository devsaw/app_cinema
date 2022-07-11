package br.digitalhouse.app_cinema.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.digitalhouse.app_cinema.data.database.Favoritos
import br.digitalhouse.app_cinema.data.database.dao.FavoritosDAO

@Database(entities = [Favoritos::class], version = 1)
abstract class FavoritosDatabase : RoomDatabase() {
    abstract fun getFavoritosDAO(): FavoritosDAO

}