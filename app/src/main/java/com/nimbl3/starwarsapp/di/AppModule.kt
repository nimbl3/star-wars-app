package com.nimbl3.starwarsapp.di

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideApolloClient(url: String) = ApolloClient.builder()
            .serverUrl(url)
            .okHttpClient(OkHttpClient().newBuilder().build())
            .build()


    @Provides
    fun provideServerUrl() = "https://swapi.apis.guru/"
}