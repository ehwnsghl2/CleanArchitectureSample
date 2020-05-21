package com.brandjunhoe.cleanarchitecture.di.module

import android.content.Context
import com.brandjunhoe.cleanarchitecture.R
import com.brandjunhoe.data.ApiService
import com.brandjunhoe.data.ReposRepositoryImpl
import com.brandjunhoe.data.mapper.ReposMapper
import com.brandjunhoe.domain.repository.ReposRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RepositoryModule {

    @Provides
    @Named("ReposRepositoryImpl")
    fun provideReposRepository(
        apiService: ApiService,
        reposMapper: ReposMapper
    ): ReposRepository {
        return ReposRepositoryImpl(apiService, reposMapper)
    }
}