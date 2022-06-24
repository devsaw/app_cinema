package br.digitalhouse.app_cinema.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import br.digitalhouse.app_cinema.R

class CanaisFragment : Fragment() {
    private lateinit var btnFavoritos: Button
    private lateinit var btnAssistir: Button
    private lateinit var btnAssistidos: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_canais, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createViews(view)
        setupClickListeners()
    }


    private fun createViews(view: View){
        btnFavoritos = view.findViewById(R.id.btnFavoritos)
        btnAssistir = view.findViewById(R.id.btnParaAssistir)
        btnAssistidos = view.findViewById(R.id.btnAssistidos)
    }

    private fun setupClickListeners() {
        btnFavoritos.setOnClickListener {
            val intentFavorites = Intent(requireContext(), TelaFavoritosFragment::class.java)
           startActivity(intentFavorites)
        }

        btnAssistir.setOnClickListener {
            val intentAssistir = Intent(requireContext(), TelaParaAssistirFragment::class.java)
            startActivity(intentAssistir)
        }

        btnAssistidos.setOnClickListener {
            val intentAssistidos = Intent(requireContext(), TelaAssistidosFragment::class.java)
            startActivity(intentAssistidos)
        }
    }
}