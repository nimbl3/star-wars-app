package com.nimbl3.starwarsapp.ui.activity.main

import android.content.Intent
import android.os.Bundle
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.ui.activity.base.BaseActivity
import com.nimbl3.starwarsapp.ui.activity.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        flFilms.setOnClickListener {
            startActivity(Intent(this@MainActivity, DetailActivity::class.java)
                    .apply { putExtra("page", 0) })
        }

        flPlanets.setOnClickListener {
            startActivity(Intent(this@MainActivity, DetailActivity::class.java)
                    .apply { putExtra("page", 1) })
        }

        flPersons.setOnClickListener {
            startActivity(Intent(this@MainActivity, DetailActivity::class.java)
                    .apply { putExtra("page", 2) })
        }

        flStarships.setOnClickListener {
            startActivity(Intent(this@MainActivity, DetailActivity::class.java)
                    .apply { putExtra("page", 3) })
        }

        flVehicles.setOnClickListener {
            startActivity(Intent(this@MainActivity, DetailActivity::class.java)
                    .apply { putExtra("page", 4) })
        }
    }
}
