package br.digitalhouse.app_cinema.ui.activities


import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.data.database.Favoritos
import br.digitalhouse.app_cinema.ui.viewmodel.FavoritosViewModel
import com.squareup.picasso.Picasso

class DetalhesActivity : AppCompatActivity(R.layout.activity_detalhes) {
    private lateinit var titulo: TextView
    private lateinit var overView: TextView
    private lateinit var image: ImageView
    private lateinit var button: ImageView
    private val viewModel: FavoritosViewModel by lazy {
        FavoritosViewModel(application)
    }

    lateinit var nameMovie: String
    lateinit var imageMovie: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startView()
        getInfoMovies()
        setupListeners()
    }

    fun setupListeners() {
        button.setOnClickListener {
            var addFavoritos = Favoritos(0, nameMovie!!, imageMovie!!)
            viewModel.saveFavorite(addFavoritos)
            viewModel.getSaveFavorite()
            Thread.sleep(1000)
            Toast.makeText(
                applicationContext,
                "Filme adcionado aos Favoritos.",
                Toast.LENGTH_LONG
            ).show()
        }
        Log.i("TAG", "Filme Salvo")
    }

    private fun startView() {
        titulo = findViewById(R.id.textTitle)
        overView = findViewById(R.id.textDescription)
        image = findViewById(R.id.imageDetail)
        button = findViewById(R.id.starButton)
    }

    private fun getInfoMovies() {
        val extra = intent.extras!!
        val nameMovie = extra.getString("title")
        val descriptionMovie = extra.getString("overview")
        val imageMovie = extra.getString("filmes")
        titulo.text = nameMovie
        overView.text = descriptionMovie
        Picasso.get()
            .load(imageMovie)
            .into(image)
    }
}