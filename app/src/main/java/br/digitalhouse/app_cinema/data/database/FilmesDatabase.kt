package br.digitalhouse.app_cinema.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.digitalhouse.app_cinema.data.Favoritos
import br.digitalhouse.app_cinema.data.dao.FavoritosDAO


@Database(entities = [Favoritos::class], version = 1)
abstract class FilmesDatabase : RoomDatabase() {
    abstract fun favoritosDAO () : FavoritosDAO
}