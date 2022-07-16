package br.digitalhouse.app_cinema.data.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.digitalhouse.app_cinema.data.database.Favoritos
import br.digitalhouse.app_cinema.data.database.dao.FavoritosDAO

@Database(entities = [Favoritos::class], version = 1)
abstract class FavoritosDatabase : RoomDatabase() {
    abstract fun getFavoritosDAO(): FavoritosDAO

    companion object{
        @Volatile
        private var instance: FavoritosDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?: createDatabase(context).also { instance = it }
        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                FavoritosDatabase::class.java,
                "favoritos_db.db"
            ).build()
    }

}