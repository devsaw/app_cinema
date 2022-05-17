package br.digitalhouse.app_cinema.fragments.filmes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.fragments.filmes.model.ImageClass

class RecyclerHorizontalAdapter :
    RecyclerView.Adapter<RecyclerHorizontalAdapter.HorizontalHolder>() {
    lateinit var listaDeTopicos: List<ImageClass>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HorizontalHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_filmes, parent, false)
    )


    override fun onBindViewHolder(holder: HorizontalHolder, position: Int) {
        holder.imagem.setImageResource(listaDeTopicos[position].image)
    }

    override fun getItemCount(): Int {
        return listaDeTopicos.size
    }

    inner class HorizontalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imagem = itemView.findViewById<ImageView>(R.id.slots)
    }
}