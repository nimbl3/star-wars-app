package com.nimbl3.starwarsapp.ui.activity.detail.di

import com.nimbl3.starwarsapp.ui.activity.detail.fragment.films.FilmsFragment
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.persons.PersonsFragment
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.planets.PlanetsFragment
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.starships.StarshipsFragment
import com.nimbl3.starwarsapp.ui.activity.detail.fragment.vehicles.VehiclesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailFragmentProvider{

    @ContributesAndroidInjector
    abstract fun provideFilmsFragment() : FilmsFragment

    @ContributesAndroidInjector
    abstract fun providePersonsFragment() : PersonsFragment

    @ContributesAndroidInjector
    abstract fun providePlanetsFragment() : PlanetsFragment

    @ContributesAndroidInjector
    abstract fun provideStarshipsFragment() : StarshipsFragment

    @ContributesAndroidInjector
    abstract fun provideVehiclesFragment() : VehiclesFragment

}