package br.digitalhouse.app_cinema.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView

import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.data.database.Favoritos
import br.digitalhouse.app_cinema.ui.adapters.RecyclerFavoritosAdapter
import br.digitalhouse.app_cinema.ui.viewmodel.FavoritosViewModel

class FavoritosFragment : Fragment(R.layout.fragment_favoritos) {
    lateinit var favoritosRV: RecyclerView
    lateinit var favoritosAdapter: RecyclerFavoritosAdapter
    private lateinit var favoritosViewModel : FavoritosViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        favoritosViewModel = ViewModelProvider(this).
        get(FavoritosViewModel::class.java)
        updateRepositoryInfo()


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startView(view)
        observer()
    }

    private fun updateRepositoryInfo(){
        favoritosViewModel.getSalveFavorite()
    }


    private fun startView(view: View){
        favoritosRV = view.findViewById(R.id.recyclerViewFavoritos)
        favoritosRV.adapter = RecyclerFavoritosAdapter()

    }
    private fun observer(){
        favoritosViewModel.getFavoritosLiveData.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it.get(it.lastIndex).title.toString(), Toast.LENGTH_LONG).show()

        }
    }


}