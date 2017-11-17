package com.nimbl3.starwarsapp.ui.activity.side

import android.content.Intent
import android.os.Bundle
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.ui.activity.base.BaseActivity
import com.nimbl3.starwarsapp.ui.activity.main.MainActivity
import kotlinx.android.synthetic.main.activity_side.*

class SideActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_side)

        ivJedi.setOnClickListener { goToMainActivity("Jedi") }
        ivSith.setOnClickListener { goToMainActivity("Sith") }
    }

    private fun goToMainActivity(side: String) = startActivity(
            Intent(this, MainActivity::class.java).apply {
                putExtra("side", side)
            })
}