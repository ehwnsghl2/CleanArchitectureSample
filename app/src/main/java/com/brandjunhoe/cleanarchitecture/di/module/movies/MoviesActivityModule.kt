package com.brandjunhoe.cleanarchitecture.di.module.movies

import androidx.lifecycle.ViewModel
import com.brandjunhoe.cleanarchitecture.di.module.UseCaseModule
import com.brandjunhoe.cleanarchitecture.di.qualifier.ViewModelKey
import com.brandjunhoe.presentation.ui.movie.MovieViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [UseCaseModule::class])
abstract class MoviesActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    abstract fun bindViewModel(viewModel: MovieViewModel): ViewModel
}