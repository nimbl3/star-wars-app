package com.nimbl3.starwarsapp.ui.activity.detail.fragment.persons

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.query.AllPeopleQuery.person
import kotlinx.android.synthetic.main.item_person.view.*
import kotlin.properties.Delegates

open class PersonsAdapter : RecyclerView.Adapter<PersonsViewHolder>() {

    open var persons by Delegates.observable(listOf<person>()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonsViewHolder =
            PersonsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false))

    override fun onBindViewHolder(holder: PersonsViewHolder, position: Int) {
        holder.bind(persons[position])
    }

    override fun getItemCount(): Int = persons.size
}

class PersonsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvItemPersonName = itemView.tvItemPersonName
    private val tvItemPersonGender = itemView.tvItemPersonGender
    private val tvItemPersonHomeWorld = itemView.tvItemPersonHomeWorld
    private val tvItemPersonSpecies = itemView.tvItemPersonSpecies

    fun bind(person: person) {
        tvItemPersonName.text = person.name()
        tvItemPersonGender.text = "Gender: ${person.gender()}"
        tvItemPersonHomeWorld.text = "HomeWorld: ${person.homeworld()?.name() ?: "unknown"}"
        tvItemPersonSpecies.text = "Species: ${person.species()?.name() ?: "unknown"}"
    }
}