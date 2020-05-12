package com.brandjunhoe.cleanarchitecture

import com.brandjunhoe.cleanarchitecture.di.DaggerMovieComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MovieApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMovieComponent.factory().create(applicationContext)
    }
}