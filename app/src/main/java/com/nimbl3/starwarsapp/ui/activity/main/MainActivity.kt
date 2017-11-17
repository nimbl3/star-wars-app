package com.nimbl3.starwarsapp.ui.activity.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.ui.activity.base.BaseActivity
import com.nimbl3.starwarsapp.ui.activity.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val side = intent.getStringExtra("side") ?: "Jedi"

        when (side) {
            "Jedi" -> {
                tbFake.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                ivLogo.setImageResource(R.drawable.ic_starwar_black)
            }
            "Sith" -> {
                tbFake.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                ivLogo.setImageResource(R.drawable.ic_starwar_white)
            }
        }

        flFilms.setOnClickListener {
            goToDatailActivity(0)
        }

        flPlanets.setOnClickListener {
            goToDatailActivity(1)
        }

        flPersons.setOnClickListener {
            goToDatailActivity(2)
        }

        flStarships.setOnClickListener {
            goToDatailActivity(3)
        }

        flVehicles.setOnClickListener {
            goToDatailActivity(4)
        }
    }

    private fun goToDatailActivity(page: Int) = startActivity(
            Intent(this@MainActivity, DetailActivity::class.java).apply {
                putExtra("page", page)
                putExtra("side", intent.getStringExtra("side"))
            })
}
