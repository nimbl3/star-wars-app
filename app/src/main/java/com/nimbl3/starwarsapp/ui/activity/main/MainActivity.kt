package com.nimbl3.starwarsapp.ui.activity.main

import android.os.Bundle
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.ui.activity.base.BaseActivity
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.films.FilmsFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .add(R.id.contentContainer, FilmsFragment())
                .commit()
    }
}
