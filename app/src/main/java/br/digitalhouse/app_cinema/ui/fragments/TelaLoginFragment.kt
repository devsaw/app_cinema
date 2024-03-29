package br.digitalhouse.app_cinema.ui.fragments


import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.ui.interfaces.MessageInterface
import br.digitalhouse.app_cinema.ui.viewmodel.AccessViewModel

class TelaLoginFragment : Fragment(R.layout.fragment_tela_login), MessageInterface {
    private lateinit var accessViewModel: AccessViewModel
    private lateinit var emailTxt: EditText
    private lateinit var passwordTxt: EditText
    private lateinit var sigInbtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        accessViewModel = ViewModelProvider(this).get(AccessViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewInit(view)
        setupListener()
        observer()
    }

    private fun viewInit(view: View) {
        passwordTxt = view.findViewById(R.id.editTextSenha)
        emailTxt = view.findViewById(R.id.editTextUsuario)
        sigInbtn = view.findViewById(R.id.btnLogarLogin)
    }

    fun setupListener() {
        sigInbtn.setOnClickListener {
            var txtLogin = emailTxt.text.toString()
            var txtSenha = passwordTxt.text.toString()
            if (textIsBlank(txtLogin, txtSenha)) {
                showMessage("Preencha os campos!")
            } else {
                accessViewModel.onEmailSignIn(txtLogin, txtSenha)

            }
        }
    }

    private fun observer() {
        accessViewModel.userAuthLiveData.observe(viewLifecycleOwner) { status ->
            when (status) {
                true ->  navigatioToPrincipal()
                false -> showMessage("Dados incorretos!")
            }
        }
    }

    private fun navigatioToPrincipal() {
        findNavController().navigate(R.id.action_telaLoginFragment_to_telaPrincipalFragment)
        showMessage("Logado!")
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun textIsBlank(login: String, senha: String): Boolean {
        return login.isBlank() || senha.isBlank()
    }


}