package br.digitalhouse.app_cinema.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.data.dto.Resultados
import com.squareup.picasso.Picasso

class RecyclerSearchViewAdapter(private val results: List<Resultados> = mutableListOf()) :
    RecyclerView.Adapter<RecyclerSearchViewAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
    )

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) =
        holder.bind(results[position])


    override fun getItemCount(): Int = results.size


    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val foto: ImageView = itemView.findViewById(R.id.foto)
        private val nome: TextView = itemView.findViewById(R.id.nome)
        fun bind(result: Resultados) {
            Picasso.get()
                .load(getImageSearchUrl(result.fotos))
                .into(foto)
            nome.text = result.pesquisados
        }

        private fun getImageSearchUrl(path: String): String {
            val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
            return "$BASE_IMAGE_URL$path"
        }
    }
}