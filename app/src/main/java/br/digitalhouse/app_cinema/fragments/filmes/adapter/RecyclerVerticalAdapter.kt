package br.digitalhouse.app_cinema.fragments.filmes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.fragments.filmes.model.ImageClass

class RecyclerVerticalAdapter :
    RecyclerView.Adapter<RecyclerVerticalAdapter.VerticalHolder>() {
    lateinit var listaDeTopicos: List<ImageClass>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VerticalHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_slots, parent, false)
    )


    override fun onBindViewHolder(holder: VerticalHolder, position: Int) {
        holder.imagem.setImageResource(listaDeTopicos[position].image)
    }

    override fun getItemCount(): Int {
        return listaDeTopicos.size
    }

    inner class VerticalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imagem = itemView.findViewById<ImageView>(R.id.card)

    }
}