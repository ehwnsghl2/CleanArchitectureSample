package com.brandjunhoe.data

import com.brandjunhoe.common.networkThreadWithMainThread
import com.brandjunhoe.data.mapper.ReposMapper
import com.brandjunhoe.domain.entity.Repos
import com.brandjunhoe.domain.repository.ReposRepository
import io.reactivex.Single
import javax.inject.Inject

class ReposRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val reposMapper: ReposMapper
) : ReposRepository {
    override fun getRepos(username: String): Single<List<Repos>> {
        return apiService.repos(username)
            .networkThreadWithMainThread()
            .map(reposMapper::mapFromEntity)
    }
}