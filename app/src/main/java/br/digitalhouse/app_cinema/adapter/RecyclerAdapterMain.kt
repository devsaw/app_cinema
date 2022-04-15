package br.digitalhouse.app_cinema.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.data.Imagens


class RecyclerAdapterMain (val context : Context, var listaDeImagens : List<Imagens>) : RecyclerView.Adapter<RecyclerAdapterMain.ImageViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        var layoutInflater = LayoutInflater.from(context).inflate(R.layout.recycler_item_filmes,parent,false)
        return ImageViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.imagem.setImageResource(listaDeImagens[position].image)
    }

    override fun getItemCount(): Int {
        return listaDeImagens.size
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imagem = itemView.findViewById<ImageView>(R.id.film_cover)
    }
}