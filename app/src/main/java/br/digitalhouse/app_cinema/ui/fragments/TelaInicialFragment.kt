package br.digitalhouse.app_cinema.ui.fragments


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.ui.interfaces.MessageInterface
import br.digitalhouse.app_cinema.ui.viewmodel.AccessViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.SignInButton
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class TelaInicialFragment : Fragment(R.layout.fragment_tela_inicial), MessageInterface {
    private lateinit var googleBtn: SignInButton
    private lateinit var accessViewModel: AccessViewModel
    private lateinit var btnLogarInicial: ImageButton
    private lateinit var btnCriarContaInicial: ImageButton
    var firebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        accessViewModel = ViewModelProvider(this).get(AccessViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        navigationToScreen()
        observer()
    }

    private fun navigationToScreen() {
        btnLogarInicial.setOnClickListener {
            findNavController().navigate(R.id.action_telaInicialFragment_to_telaLoginFragment)
        }

        btnCriarContaInicial.setOnClickListener {
            findNavController().navigate(R.id.action_telaInicialFragment_to_telaCriarContaFragment)
        }

        googleBtn.setOnClickListener{
            findNavController().navigate(R.id.action_telaInicialFragment_to_telaPrincipalFragment)
            val googleSignInIntent = accessViewModel.signInGoogleConfig(requireActivity())
            startActivityForResult(googleSignInIntent,accessViewModel.GOOGLE_REQUEST_CODE)

        }

    }

    private fun initView(view : View) {
        googleBtn = view.findViewById(R.id.logoGmail)
        btnCriarContaInicial = view.findViewById(R.id.btnCriarContaInicial)
        btnLogarInicial = view.findViewById(R.id.btnLogarInicial)
    }

    private fun observer(){
        accessViewModel.onUserRequestToGoogleSignInLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                showMessage("Usuário logado!")
            } else {
                showMessage("Falha ao logar!")
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == accessViewModel.GOOGLE_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                accessViewModel.onGoogleSignInSucess(data!!)
                val accountTask = GoogleSignIn.getSignedInAccountFromIntent(data)
                val credential = GoogleAuthProvider.getCredential(accountTask.result.idToken, null)
                firebaseAuth.signInWithCredential(credential).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val user = accountTask.result
                        accessViewModel.onCreateUser(
                            user.email.toString(),
                            null
                        )
                    } else {
                        showMessage("Erro ao logar!")
                    }
                }
            }
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
    }
}