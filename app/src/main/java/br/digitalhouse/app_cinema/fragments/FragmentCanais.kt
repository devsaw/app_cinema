package br.digitalhouse.app_cinema.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.activities.TelaAssistidos
import br.digitalhouse.app_cinema.activities.TelaFavoritos
import br.digitalhouse.app_cinema.activities.TelaParaAssistir
import br.digitalhouse.app_cinema.activities.TelaRedefinirSenha

class FragmentCanais : Fragment(R.layout.fragment_canais) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        botaoFavoritos()
        botaoAssistir()
        botaoAssistidos()
    }


    fun botaoFavoritos() {
        var btnFavoritos = view?.findViewById<Button>(R.id.btnFavoritos)
        btnFavoritos?.setOnClickListener {
            var intentFav = Intent(requireContext(), TelaFavoritos::class.java)
            startActivity(intentFav)
        }
    }

    fun botaoAssistir() {
        var btnAssistir = view?.findViewById<Button>(R.id.btnParaAssistir)
        btnAssistir?.setOnClickListener {
            var intentAssist = Intent(requireContext(), TelaParaAssistir::class.java)
            startActivity(intentAssist)
        }
    }

    fun botaoAssistidos() {
        var btnAssistidos = view?.findViewById<Button>(R.id.btnAssistidos)
        btnAssistidos?.setOnClickListener {
            var intentAssistidos = Intent(requireContext(), TelaAssistidos::class.java)
            startActivity(intentAssistidos)
        }
    }
}