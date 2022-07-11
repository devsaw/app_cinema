package br.digitalhouse.app_cinema.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import br.digitalhouse.app_cinema.R

class FavoritosFragment : Fragment() {


    //   private val BUNDLE_REQUEST_KEY: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_favoritos,
            container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //       setFragmentResult(BUNDLE_REQUEST_KEY){ key, bundle ->
        //          val result = extra.getString(key, "vazio")
        //          MoviesViewModel.insert(Favoritos(result))

        /*

        Vitor Gabriel Silva Nascimento20:10
    val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "database-name"
            ).build()
    Vitor Gabriel Silva Nascimento20:11
    val favoritosDao = db.getFavoritosDAO()
    Vitor Gabriel Silva Nascimento20:13
    val favoritos: List<Favoritos> = favoritosDao.getAll()
    favoritosDao.insert()
    favoritosDao.delete()
    Vitor Gabriel Silva Nascimento20:15
    https://developer.android.com/training/data-storage/room*/
    }


}