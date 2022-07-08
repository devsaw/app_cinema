package br.digitalhouse.app_cinema.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.data.dto.Names
import br.digitalhouse.app_cinema.data.dto.Resultados
import com.squareup.picasso.Picasso

class RecyclerSearchViewAdapter(private val results: MutableList<Resultados> = mutableListOf()) :
    RecyclerView.Adapter<RecyclerSearchViewAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
    )

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) =
        holder.bind(results[position])


    override fun getItemCount(): Int = results.size

    fun update(movie: Names) {
        this.results.clear()
        this.results.addAll(movie.names)
        this.notifyDataSetChanged()
    }


    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val foto: ImageView = itemView.findViewById(R.id.foto)
        private val nome: TextView = itemView.findViewById(R.id.nome)
        private val rvSv: RecyclerView = itemView.findViewById(R.id.recyclerViewSearch)
        fun bind(result: Resultados) {
            rvSv.layoutManager = LinearLayoutManager(itemView.context, RecyclerView.VERTICAL, false)
            rvSv.adapter = RecyclerSearchViewAdapter(results)
            Picasso.get()
                .load(getImageSearchUrl(result.pictures))
                .into(foto)
            nome.text = result.titleMovie
        }

        private fun getImageSearchUrl(path: String): String {
            val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
            return "$BASE_IMAGE_URL$path"
        }
    }
}