package com.nimbl3.starwarsapp.ui.activity.detail.fragment.persons

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.apollographql.apollo.rx2.Rx2Apollo
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.query.AllPeopleQuery
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.base.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_persons.*

class PersonsFragment : BaseFragment() {
    override fun getLayout(): Int = R.layout.fragment_persons

    private val personsAdapter by lazy { PersonsAdapter() }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvPersons?.apply {
            adapter = personsAdapter
            layoutManager = LinearLayoutManager(context)
        }

        Rx2Apollo.from(apolloClient.query(AllPeopleQuery.builder().build()))
                .subscribeOn(Schedulers.io())
                .map { response ->
                    response.data()?.allPeople()?.people()
                            ?: throw IllegalArgumentException("can not get persons")
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    personsAdapter.persons = it
                }, {
                    Log.i("call", "fail")
                })
    }

}