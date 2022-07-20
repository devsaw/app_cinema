package br.digitalhouse.app_cinema.ui.fragments


import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.ui.interfaces.MessageInterface
import br.digitalhouse.app_cinema.ui.viewmodel.AccessViewModel

class TelaCriarContaFragment : Fragment(R.layout.fragment_tela_criar_conta),MessageInterface {
    private lateinit var registerbtn: Button
    private lateinit var emailTxt: EditText
    private lateinit var passwordTxt: EditText
    private lateinit var accessViewModel: AccessViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        accessViewModel = ViewModelProvider(this).get(AccessViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewComponent()
        setupListener()
        setupObserver()
    }

    private fun setupListener() {
        registerbtn.setOnClickListener {
            accessViewModel.onCreateUser(
                emailTxt.text.toString(),passwordTxt.text.toString())
        }
    }
    private fun setupObserver() {
        accessViewModel.createUserLiveData.observe(viewLifecycleOwner){
            if(it){
                findNavController().navigate(R.id.action_telaCriarContaFragment_to_telaLoginFragment)
                showMessage("Usuario Criado com sucesso")
            } else {
                showMessage("Erro ao Criar usuário, tente novamente")
            }
        }
    }

    private fun initViewComponent() {
        registerbtn = requireView().findViewById(R.id.btnCriarContaCriarConta)
        emailTxt = requireView().findViewById(R.id.editTextEmailCriar)
        passwordTxt = requireView().findViewById(R.id.editTextSenhaCriar)
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
    }
}