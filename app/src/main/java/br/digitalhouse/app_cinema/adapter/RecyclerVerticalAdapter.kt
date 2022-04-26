package br.digitalhouse.app_cinema.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R

class RecyclerVerticalAdapter() :
    RecyclerView.Adapter<RecyclerVerticalAdapter.VerticalHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VerticalHolder(
             LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_horizontal, parent, false)
        )


    override fun onBindViewHolder(holder: VerticalHolder, position: Int) {

    }

    override fun getItemCount(): Int = 7

    inner class VerticalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }      
}