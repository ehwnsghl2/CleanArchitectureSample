package com.brandjunhoe.cleanarchitecture.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brandjunhoe.cleanarchitecture.di.ViewModelFactory
import com.brandjunhoe.cleanarchitecture.di.qualifier.ViewModelKey
import com.brandjunhoe.presentation.ui.repos.ReposViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module(includes = [UseCaseModule::class])
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ReposViewModel::class)
    abstract fun bindReposViewModel(viewModel: ReposViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory
}