package com.nimbl3.starwarsapp.ui.activity.detail.fragment.starships

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.apollographql.apollo.rx2.Rx2Apollo
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.query.AllStarShipsQuery
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.base.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_starships.*

class StarshipsFragment : BaseFragment() {
    override fun getLayout(): Int = R.layout.fragment_starships

    private val starshipsAdapter by lazy { StarshipsAdapter() }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvStarships?.apply {
            adapter = starshipsAdapter
            layoutManager = LinearLayoutManager(context)
        }

        Rx2Apollo.from(apolloClient.query(AllStarShipsQuery.builder().build()))
                .subscribeOn(Schedulers.io())
                .map { response ->
                    response.data()?.allStarships()?.starships()
                            ?: throw IllegalArgumentException("can not get starships")
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    starshipsAdapter.starships = it
                }, {
                    Toast.makeText(context,"Call Failed.", Toast.LENGTH_SHORT).show()
                })
    }
}