package br.digitalhouse.app_cinema.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.view.TelaAssistidosActivity
import br.digitalhouse.app_cinema.view.TelaFavoritosActivity
import br.digitalhouse.app_cinema.view.TelaParaAssistirActivity

class CanaisFragment : Fragment(R.layout.fragment_canais) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        botaoFavoritos()
        botaoAssistir()
        botaoAssistidos()
    }


    fun botaoFavoritos() {
        var btnFavoritos = view?.findViewById<Button>(R.id.btnFavoritos)
        btnFavoritos?.setOnClickListener {
            var intentFav = Intent(requireContext(), TelaFavoritosActivity::class.java)
            startActivity(intentFav)
        }
    }

    fun botaoAssistir() {
        var btnAssistir = view?.findViewById<Button>(R.id.btnParaAssistir)
        btnAssistir?.setOnClickListener {
            var intentAssist = Intent(requireContext(), TelaParaAssistirActivity::class.java)
            startActivity(intentAssist)
        }
    }

    fun botaoAssistidos() {
        var btnAssistidos = view?.findViewById<Button>(R.id.btnAssistidos)
        btnAssistidos?.setOnClickListener {
            var intentAssistidos = Intent(requireContext(), TelaAssistidosActivity::class.java)
            startActivity(intentAssistidos)
        }
    }
}