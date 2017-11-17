package com.nimbl3.starwarsapp.ui.activity.detail

import android.os.Bundle
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.ui.activity.base.BaseActivity
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.films.FilmsFragment
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.persons.PersonsFragment
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.planets.PlanetsFragment
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.starships.StarshipsFragment
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.vehicles.VehiclesFragment

class DetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
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