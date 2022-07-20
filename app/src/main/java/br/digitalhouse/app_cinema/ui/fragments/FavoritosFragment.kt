package br.digitalhouse.app_cinema.ui.fragments


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.room.RoomDatabase
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.data.database.Favoritos
import br.digitalhouse.app_cinema.ui.adapters.RecyclerFavoritosAdapter
import br.digitalhouse.app_cinema.ui.viewmodel.FavoritosViewModel
import kotlinx.coroutines.launch

class FavoritosFragment : Fragment(R.layout.fragment_favoritos) {
    lateinit var favoritosRV: RecyclerFavoritosAdapter

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
       // exibeLista()

    }
    private fun updateRepositoryInfo(){
        favoritosViewModel.getSaveFavorite()
    }

    private fun startView(view: View){
        favoritosRV = RecyclerFavoritosAdapter()
        view.findViewById<RecyclerView>(R.id.recyclerViewFavoritos).adapter = favoritosRV

    }
    private fun observer(){
        favoritosViewModel.getFavoritosLiveData.observe(viewLifecycleOwner) {
            for (favorito in it){
                favoritosViewModel.updateFavoritos(favorito)
            }

          //  favoritosViewModel.updateFavoritos(it)

          //  Toast.makeText(requireContext(), it.get(it.lastIndex).title.toString(), Toast.LENGTH_LONG).show()

        }

    }
    private fun exibeLista(favoritos: Favoritos){

        favoritosRV.add(favoritos)
    }

}
