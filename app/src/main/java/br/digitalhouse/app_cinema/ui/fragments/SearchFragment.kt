package br.digitalhouse.app_cinema.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.ui.activities.DetalhesActivity
import br.digitalhouse.app_cinema.ui.adapters.RecyclerSearchViewAdapter
import br.digitalhouse.app_cinema.ui.viewmodel.MoviesViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchFragment : Fragment(R.layout.fragment_search) {

    lateinit var searchView: SearchView
    lateinit var rvSearchView: RecyclerSearchViewAdapter
    private val moviesViewModel: MoviesViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponentView()
        requestSearch()
    }

    private fun initComponentView() {
        searchView = requireView().findViewById(R.id.pesquisar)
        rvSearchView = RecyclerSearchViewAdapter(onItemClicked = { titleMovie, overviews, pictures ->
            val intentDetail = Intent(requireContext(), DetalhesActivity::class.java)
            intentDetail.putExtra("title", titleMovie)
            intentDetail.putExtra("overview", overviews)
            intentDetail.putExtra("filmes", pictures)
            startActivity(intentDetail)
        })
        requireView().findViewById<RecyclerView>(R.id.recyclerViewSearch).adapter = rvSearchView
    }

    private fun requestSearch() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            private var searchJob: Job? = null
            override fun onQueryTextSubmit(search: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(search: String?): Boolean {
                searchJob?.cancel()
                searchJob = if (!search.isNullOrBlank()) {
                    lifecycleScope.launch {
                        delay(700)
                        val fetchMovie = moviesViewModel.fetchMovies(search)
                        rvSearchView.update(fetchMovie)
                    }
                } else {
                    null
                }
                return true
            }
        })
    }
}

