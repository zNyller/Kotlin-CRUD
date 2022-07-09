package com.nyller.android.kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nyller.android.kotlin.R
import com.nyller.android.kotlin.models.Habito
import kotlinx.android.synthetic.main.adapter_habito.view.*

class AdapterHabitos (private val items : ArrayList<Habito>) : RecyclerView.Adapter<AdapterHabitos.HabitoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHabitos.HabitoViewHolder {
        return HabitoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_habito, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HabitoViewHolder, position: Int) {
        val habito: Habito = items[position]
        holder.habitoNome.text = habito.nome
        holder.habitoTurno.text = habito.turno
        holder.habitoCategoria.text = habito.categoria
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class HabitoViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView){

        val habitoNome : TextView = itemView.findViewById(R.id.habito)
        val habitoTurno : TextView = itemView.findViewById(R.id.turno)
        val habitoCategoria : TextView = itemView.findViewById(R.id.categoria)

    }


}