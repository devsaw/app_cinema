package br.digitalhouse.app_cinema.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.data.dto.Feed


class RecyclerVerticalAdapter(private val listaFeed: MutableList<Feed> = mutableListOf()) :
    RecyclerView.Adapter<RecyclerVerticalAdapter.VerticalHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VerticalHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_slots, parent, false)
    )

    override fun onBindViewHolder(holder: VerticalHolder, position: Int) = holder.bind(listaFeed[position])

    override fun getItemCount(): Int = listaFeed.size

    fun add(listagem: List<Feed>) {
        this.listaFeed.clear()
        this.listaFeed.addAll(listagem)
        this.notifyDataSetChanged()
    }

    inner class VerticalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val recyclerView = itemView.findViewById<RecyclerView>(R.id.recyclerSlots)
        fun bind(feed: Feed) {
            recyclerView.layoutManager = LinearLayoutManager(
                itemView.context, RecyclerView.HORIZONTAL, false
            )
            recyclerView.adapter = RecyclerHorizontalAdapter(feed.populares)
        }
    }
}