package br.digitalhouse.app_cinema.ui.activities


import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.digitalhouse.app_cinema.R
import com.squareup.picasso.Picasso

class DetalhesActivity : AppCompatActivity(R.layout.activity_detalhes) {
    private lateinit var titulo: TextView
    private lateinit var overView: TextView
    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startView()
        getInfo()
    }

    private fun startView() {
        titulo = findViewById(R.id.textTitle)
        overView = findViewById(R.id.textDescription)
        image = findViewById(R.id.imageDetail)
    }

    private fun getInfo() {
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