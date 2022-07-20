package br.digitalhouse.app_cinema.ui.model

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class UserDAO {

    fun insertUser(user : UserDataClass){
        var database = Firebase.database.getReference("users")
        database.child(user.id).setValue(user)
    }

}