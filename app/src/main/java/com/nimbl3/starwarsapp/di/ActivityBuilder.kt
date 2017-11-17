package com.nimbl3.starwarsapp.di

import com.nimbl3.starwarsapp.ui.activity.detail.DetailActivity
import com.nimbl3.starwarsapp.ui.activity.detail.di.DetailFragmentProvider
import com.nimbl3.starwarsapp.ui.activity.main.di.MainActivityModule
import com.nimbl3.starwarsapp.ui.activity.main.MainActivity
import com.nimbl3.starwarsapp.ui.activity.side.SideActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = arrayOf(DetailFragmentProvider::class))
    abstract fun bindDetailActivity(): DetailActivity

    @ContributesAndroidInjector
    abstract fun bindSideActivity(): SideActivity
}