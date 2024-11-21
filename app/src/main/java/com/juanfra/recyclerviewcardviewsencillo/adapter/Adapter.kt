package com.juanfra.recyclerviewcardviewsencillo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.juanfra.recyclerviewcardviewsencillo.R

/*
Autor: Juan Francisco Sánchez González
Fecha: 21/11/2024
Clase: Adaptador personalizado para el RecyclerView. Se le pasa al constructor una lista (textos) y
una función para gestionar el evento Click de los elementos
 */

class Adapter(private val listaTextos:List<String>, private val onItemClick: (Int) -> Unit): RecyclerView.Adapter<Adapter.AdepaterViewHolder>() {

    // Definimos el ViewHolder interno al adaptador. Se utiliza para el renderizado e instanciación
    // de cada elemento (texto) del RecyclerView
    class AdepaterViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val card: CardView = item.findViewById(R.id.cardView)
        val texto: TextView = item.findViewById(R.id.textView)
    }

    // Infla la vista de cada elemento del listado (CardView) en el RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdepaterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AdepaterViewHolder(layoutInflater.inflate(R.layout.item_rcv, parent, false))
    }

    // Número de elementos de la lista
    override fun getItemCount(): Int = listaTextos.size

    // Llamada a ViewHolder para el renderizado y asignación de los datos a cada elemento del listado
    override fun onBindViewHolder(holder: AdepaterViewHolder, position: Int) {
        holder.texto.text = listaTextos[position]
        // Asignación evento OnClick al control CardView
        holder.card.setOnClickListener{ onItemClick(position) }
    }

}