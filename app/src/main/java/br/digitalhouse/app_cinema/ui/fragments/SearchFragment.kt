package br.digitalhouse.app_cinema.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.ui.adapters.RecyclerSearchViewAdapter
import br.digitalhouse.app_cinema.ui.viewmodel.MoviesViewModel
import kotlinx.coroutines.launch

class SearchFragment : Fragment() {

    lateinit var searchView : SearchView
    lateinit var rvSearchView: RecyclerSearchViewAdapter
    private val moviesViewModel: MoviesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchView = view.findViewById(R.id.pesquisar)
        rvSearchView = RecyclerSearchViewAdapter()
        view.findViewById<RecyclerView>(R.id.recyclerViewSearch).adapter = rvSearchView
        requestSearch()
    }

    private fun requestSearch() {
        lifecycleScope.launch {
            val filmes = moviesViewModel.fetchMovies()

        }
    }
}