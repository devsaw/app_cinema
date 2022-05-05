package br.digitalhouse.app_cinema.adapter.adapterprincipal.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R

class RecyclerHorizontalAdapter() :
    RecyclerView.Adapter<RecyclerHorizontalAdapter.HorizontalHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HorizontalHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_filmes, parent, false)
    )


    override fun onBindViewHolder(holder: HorizontalHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 30

    inner class HorizontalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind() {
            with(itemView) {

            }
        }
    }
}