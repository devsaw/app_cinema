package br.digitalhouse.app_cinema.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.ui.adapters.RecyclerFavoritosAdapter
import br.digitalhouse.app_cinema.ui.viewmodel.FavoritosViewModel

class FavoritosFragment : Fragment(R.layout.fragment_favoritos) {
    lateinit var favoritosRV: RecyclerView
    private lateinit var favoritosViewModel : FavoritosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoritosViewModel = ViewModelProvider(this).
        get(FavoritosViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    private fun startView(){
        favoritosRV = requireView().findViewById(R.id.recyclerViewFavoritos)
        favoritosRV.adapter = RecyclerFavoritosAdapter()

    }

}