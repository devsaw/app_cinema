package br.digitalhouse.app_cinema.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.adapter.RecyclerAdapterHorizontal
import br.digitalhouse.app_cinema.adapter.RecyclerAdapterVertical

class FragmentFilmes : Fragment() {

    var recyclerAdapterVertical: RecyclerAdapterVertical? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filmes, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerAdapterVertical = RecyclerAdapterVertical()
        view.findViewById<RecyclerView>(R.id.rv_vertical).adapter = RecyclerAdapterVertical()

    }
}