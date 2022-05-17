package br.digitalhouse.app_cinema.fragments.filmes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.fragments.filmes.adapter.RecyclerHorizontalAdapter
import br.digitalhouse.app_cinema.fragments.filmes.adapter.RecyclerVerticalAdapter

class FilmesFragment : Fragment() {

    var recyclerVerticalAdapter: RecyclerVerticalAdapter? = null
    var recyclerHorizontalAdapter: RecyclerHorizontalAdapter?= null

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
        view.findViewById<RecyclerView>(R.id.slots).adapter = RecyclerVerticalAdapter()
        recyclerHorizontalAdapter = RecyclerHorizontalAdapter()
        view.findViewById<RecyclerView>(R.id.card).adapter = RecyclerHorizontalAdapter()

    }
}