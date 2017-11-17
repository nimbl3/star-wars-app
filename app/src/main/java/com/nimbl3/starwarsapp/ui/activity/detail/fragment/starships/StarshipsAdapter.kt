package com.nimbl3.starwarsapp.ui.activity.detail.fragment.starships

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.query.AllStarShipsQuery.Starship
import kotlinx.android.synthetic.main.item_starship.view.*
import kotlin.properties.Delegates

open class StarshipsAdapter : RecyclerView.Adapter<StarshipsViewHolder>() {

    open var starships by Delegates.observable(listOf<Starship>()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarshipsViewHolder =
            StarshipsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_starship, parent, false))

    override fun onBindViewHolder(holder: StarshipsViewHolder, position: Int) {
        holder.bind(starships[position])
    }

    override fun getItemCount(): Int = starships.size
}

class StarshipsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvItemStarshipName = itemView.tvItemStarshipName
    private val tvItemStarshipModel = itemView.tvItemStarshipModel
    private val tvItemStarshipCrew = itemView.tvItemStarshipCrew
    private val tvItemStarshipClass = itemView.tvItemStarshipClass

    fun bind(starship: Starship) {
        tvItemStarshipName.text = starship.name()
        tvItemStarshipModel.text = starship.model()
        tvItemStarshipCrew.text = starship.crew()
        tvItemStarshipClass.text = starship.starshipClass()
    }
}