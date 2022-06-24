package br.digitalhouse.app_cinema.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.data.ImageDownloader
import br.digitalhouse.app_cinema.data.dto.Resultados

class RecyclerSearchViewAdapter(private val results: List<Resultados> = mutableListOf()) :
    RecyclerView.Adapter<RecyclerSearchViewAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_search, parent, false)
    )

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) =
        holder.bind(results[position])


    override fun getItemCount(): Int = results.size


    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val foto: ImageView = itemView.findViewById(R.id.foto)
        private val nome: TextView = itemView.findViewById(R.id.nome)

        fun bind(result: Resultados) {
            ImageDownloader.download(foto, result.fotos)
            nome.text = result.pesquisados
        }
    }
}