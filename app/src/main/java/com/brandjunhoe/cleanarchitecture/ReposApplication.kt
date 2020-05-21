package com.brandjunhoe.cleanarchitecture

import com.brandjunhoe.cleanarchitecture.di.component.DaggerReposComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class ReposApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerReposComponent.factory().create(this)
    }
}