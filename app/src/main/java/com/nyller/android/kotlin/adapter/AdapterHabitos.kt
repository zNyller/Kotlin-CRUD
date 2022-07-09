package com.nyller.android.kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nyller.android.kotlin.R
import com.nyller.android.kotlin.databinding.ActivityAddHabitoBinding
import com.nyller.android.kotlin.databinding.ActivityMainBinding
import com.nyller.android.kotlin.databinding.AdapterHabitoBinding
import com.nyller.android.kotlin.models.Habito

class AdapterHabitos (private val items : ArrayList<Habito>) : RecyclerView.Adapter<AdapterHabitos.HabitoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHabitos.HabitoViewHolder {
        return HabitoViewHolder(
            AdapterHabitoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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

    inner class HabitoViewHolder constructor(itemView: AdapterHabitoBinding): RecyclerView.ViewHolder(itemView.root){

        val habitoNome : TextView = itemView.habito
        val habitoTurno : TextView = itemView.turno
        val habitoCategoria : TextView = itemView.categoria

    }
}