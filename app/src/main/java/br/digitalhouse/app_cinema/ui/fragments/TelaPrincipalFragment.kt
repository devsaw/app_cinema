package br.digitalhouse.app_cinema.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.ui.adapters.TabLayoutAdapter
import com.google.android.material.tabs.TabLayout

class TelaPrincipalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_principal, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var adapterTab = TabLayoutAdapter(parentFragmentManager)
        adapterTab.add(FilmesFragment(), "Filmes")
        adapterTab.add(SearchFragment(), "Buscar")
        adapterTab.add(CanaisFragment(), "Canais")
        adapterTab.add(ContaFragment(), "Conta")


        var pager = view.findViewById<ViewPager>(R.id.viewPager)
        pager.adapter = adapterTab

        var tabLayout = view.findViewById<TabLayout>(R.id.myTabLayout)
        tabLayout.setupWithViewPager(pager)
    }


}