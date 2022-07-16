package br.digitalhouse.app_cinema.data.database.dao

import android.content.Context
import androidx.room.Room
import br.digitalhouse.app_cinema.data.database.Favoritos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FavoritosRepository(context: Context) {

    private val db = Room.databaseBuilder(
        context,
        FavoritosDatabase::class.java, "favoritos"
    ).build()


    suspend fun saveFavorite(favoritos: Favoritos) =
        withContext(Dispatchers.IO) {
        db.getFavoritosDAO().insert(favoritos)
    }

    suspend fun delete(favoritos: Favoritos) =
        withContext(Dispatchers.IO) {
        db.getFavoritosDAO().delete(favoritos)
    }

    suspend fun getAll(): List<Favoritos> =
        withContext(Dispatchers.IO) {
        db.getFavoritosDAO().getAll()
    }


}