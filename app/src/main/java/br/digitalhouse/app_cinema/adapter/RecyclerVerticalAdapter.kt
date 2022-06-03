package br.digitalhouse.app_cinema.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.digitalhouse.app_cinema.R
import br.digitalhouse.app_cinema.model.SlotsDataClass

class RecyclerVerticalAdapter :
    RecyclerView.Adapter<RecyclerVerticalAdapter.VerticalHolder>() {
    lateinit var listSlots: List<SlotsDataClass>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VerticalHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_slots, parent, false)
    )


    override fun onBindViewHolder(holder: VerticalHolder, position: Int) {
        holder.bind(listSlots[position])
    }

    override fun getItemCount(): Int {
        return listSlots.size
    }

    inner class VerticalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imagem = itemView.findViewById<ImageView>(R.id.card)
        private val recyclerView = itemView.findViewById<RecyclerView>(R.id.recyclerSlots)
        fun bind(slotsDataClass: SlotsDataClass) {
            imagem.setImageResource(slotsDataClass.slotImage)
            //recyclerView.adapter = criaAdapterHorizontal(slotsDataClass.movieList)
        }
    }
}