package br.digitalhouse.app_cinema.ui.viewmodel


import android.app.Activity
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.digitalhouse.app_cinema.ui.model.UserDAO
import br.digitalhouse.app_cinema.ui.model.UserDataClass
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AccessViewModel : ViewModel() {

    var firebaseAuth = Firebase.auth
    lateinit var gso : GoogleSignInOptions
    val GOOGLE_REQUEST_CODE = 120


    private var onUserRequestToRegister = MutableLiveData<Boolean>()
    var createUserLiveData : LiveData<Boolean> = onUserRequestToRegister

    private var onUserRequestToSignIn = MutableLiveData<Boolean>()
    var userAuthLiveData : LiveData<Boolean> = onUserRequestToSignIn

    fun onCreateUser (email : String , password : String?) {
        if(password != null) {
            var registerTask = firebaseAuth.createUserWithEmailAndPassword(email, password)

            registerTask.addOnCompleteListener {
                if (registerTask.isSuccessful) {
                    var user = UserDataClass(firebaseAuth.currentUser?.uid!!,email,password)
                    UserDAO().insertUser(user)
                    onUserRequestToRegister.value = registerTask.isSuccessful
                }
            }
        } else {
            var user = UserDataClass(firebaseAuth.currentUser?.uid!!,email,password)
            UserDAO().insertUser(user)
            onUserRequestToSignIn.value = true
        }
    }

    fun onEmailSignIn(email : String, password : String) {
        var authTask = firebaseAuth.signInWithEmailAndPassword(email,password)

        authTask.addOnCompleteListener {
            onUserRequestToSignIn.value = authTask.isSuccessful
        }
    }


    fun signInGoogleConfig (activity: Activity) : Intent {
        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("1023100515581-i66rv8nnq68ubo5lo5in7q868c9qaaue.apps.googleusercontent.com")
            .requestEmail()
            .build()
        return GoogleSignIn.getClient(activity,gso).signInIntent
    }
}