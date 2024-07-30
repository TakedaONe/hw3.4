package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContinentsAdapter(
    private val continents: List<Continent>,
    private val onContinentClick: (Continent) -> Unit
) : RecyclerView.Adapter<ContinentsAdapter.ContinentViewHolder>() {

    inner class ContinentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val continentName: TextView = itemView.findViewById(R.id.tvContinentName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContinentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_continent, parent, false)
        return ContinentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContinentViewHolder, position: Int) {
        val continent = continents[position]
        holder.continentName.text = continent.name
        holder.itemView.setOnClickListener {
            onContinentClick(continent)
        }
    }

    override fun getItemCount() = continents.size
}
