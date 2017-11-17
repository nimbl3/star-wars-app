package com.nimbl3.starwarsapp.ui.activity.detail

import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.ui.activity.base.BaseActivity
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.films.FilmsFragment
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.persons.PersonsFragment
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.planets.PlanetsFragment
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.starships.StarshipsFragment
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.vehicles.VehiclesFragment
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setSupportActionBar(toolbar)

        val side = intent.getStringExtra("side") ?: "Jedi"



        when (side) {
            "Jedi" -> {
                toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.black))
            }
            "Sith" -> {
                toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white))
            }
        }


        val page = intent.let { it.getIntExtra("page", 0) }


        when (page) {
            0 -> {
                supportFragmentManager.beginTransaction()
                        .add(R.id.contentContainer, FilmsFragment())
                        .commit()

                title = "Films"
            }
            1 -> {
                supportFragmentManager.beginTransaction()
                        .add(R.id.contentContainer, PlanetsFragment())
                        .commit()
                title = "Planets"
            }
            2 -> {
                supportFragmentManager.beginTransaction()
                        .add(R.id.contentContainer, PersonsFragment())
                        .commit()
                title = "Persons"
            }
            3 -> {
                supportFragmentManager.beginTransaction()
                        .add(R.id.contentContainer, StarshipsFragment())
                        .commit()
                title = "Starships"
            }
            4 -> {
                supportFragmentManager.beginTransaction()
                        .add(R.id.contentContainer, VehiclesFragment())
                        .commit()
                title = "Vehicles"
            }
        }
    }

}