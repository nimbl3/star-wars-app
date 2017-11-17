package com.nimbl3.starwarsapp.ui.activity.detail.fragment.films

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.query.AllFilmsQuery.Film
import kotlinx.android.synthetic.main.item_film.view.*
import kotlin.properties.Delegates

open class FilmsAdapter : RecyclerView.Adapter<FilmsViewHolder>() {

    open var films by Delegates.observable(listOf<Film>()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder =
            FilmsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false))

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.bind(films[position])
    }

    override fun getItemCount(): Int = films.size
}

class FilmsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvItemFilmName: TextView = itemView.tvItemFilmName
    private val tvItemFilmId: TextView = itemView.tvItemFilmId
    private val tvItemFilmDirector: TextView = itemView.tvItemFilmDirector
    private val tvItemFilmReleaseDate: TextView = itemView.tvItemFilmReleaseDate

    fun bind(film: Film) {
        tvItemFilmName.text = film.title()
        tvItemFilmId.text = film.episodeID().toString()
        tvItemFilmDirector.text = film.director()
        tvItemFilmReleaseDate.text = film.releaseDate()
    }
}