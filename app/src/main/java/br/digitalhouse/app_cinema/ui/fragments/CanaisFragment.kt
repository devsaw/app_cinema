package br.digitalhouse.app_cinema.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
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
        btnFavoritos = view.findViewById(R.id.btnFavoritos)
        btnAssistir = view.findViewById(R.id.btnParaAssistir)
        btnAssistidos = view.findViewById(R.id.btnAssistidos)
        setupClickListeners()
    }



    private fun setupClickListeners(){
       btnFavoritos.setOnClickListener{
           findNavController().navigate(R.id.action_canaisFragment_to_telaFavoritosFragment)
       }

        btnAssistir.setOnClickListener{
            findNavController().navigate(R.id.action_canaisFragment_to_telaParaAssistirFragment)
        }

        btnAssistidos.setOnClickListener{
            findNavController().navigate(R.id.action_canaisFragment_to_telaAssistidosFragment)
        }
    }
}