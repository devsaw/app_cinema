package br.digitalhouse.app_cinema.adapter.adaptertablayout.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabLayoutAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    var listaDeFragmentos = mutableListOf<Fragment>()
    var listaDeTitulo = mutableListOf<String>()

    fun add(fragment: Fragment, titulo: String) {
        listaDeFragmentos.add(fragment)
        listaDeTitulo.add(titulo)
    }

    override fun getCount(): Int = listaDeFragmentos.size

    override fun getItem(position: Int): Fragment = listaDeFragmentos[position]

    override fun getPageTitle(position: Int): CharSequence? = listaDeTitulo[position]


}