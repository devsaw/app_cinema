package br.digitalhouse.app_cinema.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.ui.adapters.RecyclerVerticalAdapter
import br.digitalhouse.app_cinema.ui.viewmodel.MoviesViewModel
import kotlinx.coroutines.launch

class FilmesFragment : Fragment() {

    lateinit var recyclerVerticalAdapter: RecyclerVerticalAdapter
    private val moviesViewModel: MoviesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filmes, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerVerticalAdapter = RecyclerVerticalAdapter()
        view.findViewById<RecyclerView>(R.id.rv_vertical).adapter = recyclerVerticalAdapter
        requestPopulares()
    }

    private fun requestPopulares() {
        lifecycleScope.launch {
            val feed = moviesViewModel.fetchPopular()
                recyclerVerticalAdapter.add(listOf(feed))
        }
    }
}