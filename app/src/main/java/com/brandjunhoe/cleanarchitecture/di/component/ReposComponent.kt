package com.brandjunhoe.cleanarchitecture.di.component

import android.content.Context
import com.brandjunhoe.cleanarchitecture.ReposApplication
import com.brandjunhoe.cleanarchitecture.di.module.ActivityBindingModule
import com.brandjunhoe.cleanarchitecture.di.module.NetWorkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        NetWorkModule::class]
)
interface ReposComponent : AndroidInjector<ReposApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ReposComponent
    }
}