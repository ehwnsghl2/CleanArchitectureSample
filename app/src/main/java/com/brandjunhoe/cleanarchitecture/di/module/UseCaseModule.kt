package com.brandjunhoe.cleanarchitecture.di.module

import com.brandjunhoe.domain.repository.MovieRepository
import com.brandjunhoe.domain.usecase.MovieUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [RepositoryModule::class])
class UseCaseModule {
    @Provides
    fun provideMovieUseCase(
        @Named("MovieRepositoryImpl") movieRepository: MovieRepository
    ): MovieUseCase {
        return MovieUseCase(movieRepository)
    }
}