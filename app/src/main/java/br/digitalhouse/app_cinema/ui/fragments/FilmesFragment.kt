package br.digitalhouse.app_cinema.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.adapter.RecyclerHorizontalAdapter
import br.digitalhouse.app_cinema.adapter.RecyclerVerticalAdapter

class FilmesFragment : Fragment() {

    var recyclerVerticalAdapter: RecyclerVerticalAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filmes, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerVerticalAdapter = RecyclerVerticalAdapter()
        view?.findViewById<RecyclerView>(R.id.slots)?.adapter = RecyclerVerticalAdapter()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}