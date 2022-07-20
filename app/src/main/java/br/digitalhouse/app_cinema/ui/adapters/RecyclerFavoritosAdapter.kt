package br.digitalhouse.app_cinema.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.data.database.Favoritos
import com.squareup.picasso.Picasso

class RecyclerFavoritosAdapter(
    private val listaFavoritos: MutableList<Favoritos> = mutableListOf()
) :
    RecyclerView.Adapter<RecyclerFavoritosAdapter.FavoritosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FavoritosViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_favoritos,
            parent, false
        )
    )

    override fun onBindViewHolder(
        holder: RecyclerFavoritosAdapter.FavoritosViewHolder,
        position: Int
    ) = holder.bind(listaFavoritos[position])


    override fun getItemCount(): Int = listaFavoritos.size
    fun add(lista: Favoritos) {
        this.listaFavoritos.clear()
        this.listaFavoritos.add(lista)
        this.notifyDataSetChanged()

    }


    /*fun setupListeners() {
        buttonDel.setOnClickListener {
            var addFavoritos = Favoritos(0, nameMovie!!, imageMovie!!)
            viewModel.saveFavorite(addFavoritos)
            viewModel.getSaveFavorite()
            Thread.sleep(1000)
            Toast.makeText(
                applicationContext,
                "Filme adicionado aos favoritos com sucesso",
                Toast.LENGTH_LONG
            ).show()
        }
    }*/

    inner class FavoritosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val pictureFMovie: ImageView = itemView.findViewById(R.id.recItemPicture)
        private val titleMovie: TextView = itemView.findViewById(R.id.title)
        private val buttonDel: ImageView = itemView.findViewById(R.id.imageViewdel)

        fun bind(listaFavoritos: Favoritos) {

            titleMovie.text = listaFavoritos.title
            Picasso.get()
                .load(listaFavoritos.pictureMovie)
                .into(pictureFMovie)

        }


    }


}

