package com.brandjunhoe.cleanarchitecture.di.module

import android.content.Context
import com.brandjunhoe.cleanarchitecture.R
import com.brandjunhoe.data.MovieRepositoryImpl
import com.brandjunhoe.data.MovieService
import com.brandjunhoe.data.mapper.MoviesMapper
import com.brandjunhoe.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RepositoryModule {
    @Provides
    @Named("MovieRepositoryImpl")
    fun provideMovieRepository(
        movieService: MovieService,
        moviesMapper: MoviesMapper,
        context: Context
    ): MovieRepository {
        return MovieRepositoryImpl(movieService, moviesMapper, context.getString(R.string.api_key))
    }
}