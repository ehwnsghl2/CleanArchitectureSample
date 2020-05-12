package com.brandjunhoe.cleanarchitecture.di.module

import com.brandjunhoe.cleanarchitecture.di.module.movies.MoviesActivityModule
import com.brandjunhoe.presentation.ui.detail.MovieDetailActivity
import com.brandjunhoe.presentation.ui.movie.MovieActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class,
            MoviesActivityModule::class
        ]
    )
    abstract fun bindMoviesActivity(): MovieActivity

    @ContributesAndroidInjector
    abstract fun bindMovieDetailActivity(): MovieDetailActivity
}