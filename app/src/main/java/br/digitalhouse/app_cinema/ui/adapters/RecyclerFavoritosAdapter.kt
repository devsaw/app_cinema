package br.digitalhouse.app_cinema.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.data.database.Favoritos
import br.digitalhouse.app_cinema.data.dto.Names

class RecyclerFavoritosAdapter(
    private val listaFavoritos: MutableList<Favoritos> = mutableListOf()):
    RecyclerView.Adapter<RecyclerFavoritosAdapter.FavoritosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FavoritosViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_favoritos, parent, false)
    )

    override fun onBindViewHolder(
        holder: RecyclerFavoritosAdapter.FavoritosViewHolder,
        position: Int
    ) =
        holder.bind(listaFavoritos[position])


    override fun getItemCount(): Int = listaFavoritos.size

    fun update() {
        this.listaFavoritos.clear()
       // this.listaFavoritos.addAll()
        this.notifyDataSetChanged()
    }

    inner class FavoritosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val capa: ImageView = itemView.findViewById(R.id.recItemCanais)
        private val nome: TextView = itemView.findViewById(R.id.title)
        fun bind (listaFavoritos: Favoritos){

        }

    }

}
