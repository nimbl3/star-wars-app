package com.nimbl3.starwarsapp.ui.activity.detail.fragment.vehicles

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.apollographql.apollo.rx2.Rx2Apollo
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.query.AllVehiclesQuery
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.base.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_vehicles.*

class VehiclesFragment : BaseFragment() {
    override fun getLayout(): Int = R.layout.fragment_vehicles

    private val vehiclesAdapter by lazy { VehiclesAdapter() }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvVehicles?.apply {
            adapter = vehiclesAdapter
            layoutManager = LinearLayoutManager(context)
        }

        Rx2Apollo.from(apolloClient.query(AllVehiclesQuery.builder().build()))
                .subscribeOn(Schedulers.io())
                .map { response ->
                    response.data()?.allVehicles()?.vehicles()
                            ?: throw IllegalArgumentException("can not get vehicles")
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    vehiclesAdapter.vehicles = it
                }, {
                    Log.i("call", "fail")
                })
    }
}