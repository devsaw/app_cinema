package br.digitalhouse.app_cinema.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.model.MovieDataClass
import br.digitalhouse.app_cinema.model.SlotsDataClass

class RecyclerHorizontalAdapter :
    RecyclerView.Adapter<RecyclerHorizontalAdapter.HorizontalHolder>() {
    lateinit var listMovies: List<MovieDataClass>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HorizontalHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_filmes, parent, false)
    )


    override fun onBindViewHolder(holder: HorizontalHolder, position: Int) {
        holder.bind(listMovies[position])
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    inner class HorizontalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       private val imagem = itemView.findViewById<ImageView>(R.id.film_card)
        fun bind(movieDataClass: MovieDataClass){
            imagem.setImageResource(movieDataClass.movieImage)
        }

    }
}
//Teste