package com.nimbl3.starwarsapp.ui.activity.detail.fragment.films

import android.os.Bundle
import android.util.Log
import android.view.View
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.nimbl3.starwarsapp.AllFilmsQuery
import com.nimbl3.starwarsapp.R
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.base.BaseFragment
import javax.inject.Inject

class FilmsFragment : BaseFragment() {

    @Inject lateinit var apolloClient: ApolloClient

    override fun getLayout(): Int = R.layout.fragment_films

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apolloClient.query(AllFilmsQuery.builder().build())
                .enqueue(object : ApolloCall.Callback<AllFilmsQuery.Data>() {
                    override fun onResponse(response: Response<AllFilmsQuery.Data>) {
                        Log.i("call", "success")
                    }

                    override fun onFailure(e: ApolloException) {
                        Log.i("call", "fail")
                    }
                })
    }
}