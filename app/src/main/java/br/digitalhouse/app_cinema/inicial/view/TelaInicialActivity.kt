package br.digitalhouse.app_cinema.inicial.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.login.view.TelaLoginActivity
import br.digitalhouse.app_cinema.principal.view.TelaPrincipalActivity

class TelaInicialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)
        var intent = Intent(this, TelaLoginActivity::class.java)
        startActivity(intent)

    }
}