package com.brandjunhoe.cleanarchitecture.di.module

import com.brandjunhoe.domain.repository.ReposRepository
import com.brandjunhoe.domain.usecase.ReposUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [RepositoryModule::class])
class UseCaseModule {

    @Provides
    fun provideReposUseCase(
        @Named("ReposRepositoryImpl") reposRepository: ReposRepository
    ): ReposUseCase {
        return ReposUseCase(reposRepository)
    }

}