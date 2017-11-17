package com.nimbl3.starwarsapp.ui.activity.detail.fragment.planets

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.apollographql.apollo.rx2.Rx2Apollo
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.query.AllPlanetsQuery
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.base.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_planets.*

class PlanetsFragment : BaseFragment() {
    override fun getLayout(): Int = R.layout.fragment_planets

    private val planetsAdapter by lazy { PlanetsAdapter() }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvPlanets?.apply {
            adapter = planetsAdapter
            layoutManager = LinearLayoutManager(context)
        }

        Rx2Apollo.from(apolloClient.query(AllPlanetsQuery.builder().build()))
                .subscribeOn(Schedulers.io())
                .map { response ->
                    response.data()?.allPlanets()?.planets()
                            ?: throw IllegalArgumentException("can not get planets")
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    planetsAdapter.plaents = it
                }, {
                    Toast.makeText(context,"Call Failed.", Toast.LENGTH_SHORT).show()
                })
    }
}