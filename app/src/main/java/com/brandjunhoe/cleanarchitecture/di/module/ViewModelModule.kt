package com.brandjunhoe.cleanarchitecture.di.module

import androidx.lifecycle.ViewModelProvider
import com.brandjunhoe.cleanarchitecture.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory
}