package br.digitalhouse.app_cinema.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.data.ImageDownloader
import br.digitalhouse.app_cinema.data.dto.Popular
import com.squareup.picasso.Picasso

class RecyclerHorizontalAdapter(private val populares: List<Popular>) :
    RecyclerView.Adapter<RecyclerHorizontalAdapter.HorizontalHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HorizontalHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_filmes, parent, false)
    )


    override fun onBindViewHolder(holder: HorizontalHolder, position: Int) {
        holder.bind(populares[position])
    }

    override fun getItemCount(): Int = populares.size


    inner class HorizontalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imagem = itemView.findViewById<ImageView>(R.id.film_card)
        private val titulos = itemView.findViewById<TextView>(R.id.titulos)
        fun bind(popular: Popular) {
            Picasso.get()
                .load(getImageUrl(popular.filmes))
                .into(imagem)
            titulos.text = popular.title
        }

        private fun getImageUrl(path:String) :String{
             val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
            return "BASE_IMAGE_URL$path"

        }

    }
}