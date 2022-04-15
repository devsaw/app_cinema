package br.digitalhouse.app_cinema.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.adapter.TabsAdapterMain
import br.digitalhouse.app_cinema.fragments.FragmentCanais
import br.digitalhouse.app_cinema.fragments.FragmentConta
import br.digitalhouse.app_cinema.fragments.FragmentFilmes
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter = TabsAdapterMain(supportFragmentManager)
        adapter.add(FragmentFilmes(), "Filmes")
        adapter.add(FragmentCanais(), "Canais")
        adapter.add(FragmentConta(), "Conta")

        var pager = findViewById<ViewPager>(R.id.viewPager)
        pager.adapter = adapter

        var tabLayout = findViewById<TabLayout>(R.id.myTabLayout)
        tabLayout.setupWithViewPager(pager)
    }
}