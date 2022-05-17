package br.digitalhouse.app_cinema.principal.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.fragments.canais.view.CanaisFragment
import br.digitalhouse.app_cinema.fragments.conta.view.ContaFragment
import br.digitalhouse.app_cinema.fragments.filmes.view.FilmesFragment
import br.digitalhouse.app_cinema.principal.adapter.TabLayoutAdapter
import com.google.android.material.tabs.TabLayout

class TelaPrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        var adapter = TabLayoutAdapter(supportFragmentManager)
        adapter.add(FilmesFragment(), "Filmes")
        adapter.add(CanaisFragment(), "Canais")
        adapter.add(ContaFragment(), "Conta")

        var pager = findViewById<ViewPager>(R.id.viewPager)
        pager.adapter = adapter

        var tabLayout = findViewById<TabLayout>(R.id.myTabLayout)
        tabLayout.setupWithViewPager(pager)
    }
}