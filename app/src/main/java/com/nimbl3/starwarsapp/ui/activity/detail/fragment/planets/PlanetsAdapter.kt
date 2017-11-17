package com.nimbl3.starwarsapp.ui.activity.detail.fragment.planets

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.query.AllPlanetsQuery.Planet
import kotlinx.android.synthetic.main.item_planet.view.*
import kotlin.properties.Delegates

open class PlanetsAdapter : RecyclerView.Adapter<PlanetsViewHolder>() {

    open var plaents by Delegates.observable(listOf<Planet>()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetsViewHolder =
            PlanetsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_planet, parent, false))

    override fun onBindViewHolder(holder: PlanetsViewHolder, position: Int) {
        holder.bind(plaents[position])
    }

    override fun getItemCount(): Int = plaents.size
}

class PlanetsViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    private val tvItemPlanetName = itemView.tvItemPlanetName
    private val tvItemPlanetDiameter = itemView.tvItemPlanetDiameter
    private val tvItemPlanetPopulation = itemView.tvItemPlanetPopulation

    fun bind(planet: Planet) {
        tvItemPlanetName.text = planet.name()
        tvItemPlanetDiameter.text = "Diameter: ${planet.diameter().toString()} km"
        tvItemPlanetPopulation.text = "Population: ${planet.population() ?: "unknown"}"
    }
}