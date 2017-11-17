package com.nimbl3.starwarsapp.ui.activity.detail.fragment.films

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.apollographql.apollo.rx2.Rx2Apollo
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.query.AllFilmsQuery
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.base.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_films.*

class FilmsFragment : BaseFragment() {

    override fun getLayout(): Int = R.layout.fragment_films

    private val filmsAdapter = FilmsAdapter()

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvFilms?.apply {
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(context)
        }

        Rx2Apollo.from(apolloClient.query(AllFilmsQuery.builder().build()))
                .subscribeOn(Schedulers.io())
                .map { response ->
                    response.data()?.allFilms()?.films()
                            ?: throw IllegalArgumentException("can not get films")
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    filmsAdapter.films = it
                }, {
                    Toast.makeText(context,"Call Failed.",Toast.LENGTH_SHORT).show()
                })
    }
}