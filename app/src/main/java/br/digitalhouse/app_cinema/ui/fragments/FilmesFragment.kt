package br.digitalhouse.app_cinema.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.ui.activities.DetalhesActivity
import br.digitalhouse.app_cinema.ui.adapters.RecyclerVerticalAdapter
import br.digitalhouse.app_cinema.ui.viewmodel.MoviesViewModel
import kotlinx.coroutines.launch

class FilmesFragment : Fragment(R.layout.fragment_filmes) {

    lateinit var recyclerVerticalAdapter: RecyclerVerticalAdapter
    private val moviesViewModel: MoviesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        requestPopulares()
    }

    private fun requestPopulares() {
        for(page in 1..10){
            lifecycleScope.launch{
                val feed = moviesViewModel.fetchPopular(page)
                recyclerVerticalAdapter.add(feed)
            }
        }
    }

    fun initAdapter(){
        recyclerVerticalAdapter =
            RecyclerVerticalAdapter(onItemClickedListener = { title, overview, filmes ->
                val intent = Intent(requireContext(), DetalhesActivity::class.java)
                intent.putExtra("title", title)
                intent.putExtra("overview", overview)
                intent.putExtra("filmes", filmes)
                startActivity(intent)
            })
        view?.findViewById<RecyclerView>(R.id.rv_vertical)?.adapter = recyclerVerticalAdapter
    }
}