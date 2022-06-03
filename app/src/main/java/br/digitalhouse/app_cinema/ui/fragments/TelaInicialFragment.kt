package br.digitalhouse.app_cinema.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import br.digitalhouse.app_cinema.R

class TelaInicialFragment : Fragment(R.layout.fragment_tela_inicial) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationToScreen()
    }

    private fun navigationToScreen() {
        var btnLogarInicial = view?.findViewById<ImageButton>(R.id.btnLogarInicial)
        var btnCriarContaInicial = view?.findViewById<ImageButton>(R.id.btnCriarContaInicial)
        btnLogarInicial?.setOnClickListener {
            findNavController().navigate(R.id.action_telaInicialFragment_to_telaLoginFragment)
        }

        btnCriarContaInicial?.setOnClickListener {
            findNavController().navigate(R.id.action_telaInicialFragment_to_telaCriarContaFragment)
        }
    }


}