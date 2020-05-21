package com.brandjunhoe.domain.repository

import com.brandjunhoe.domain.entity.Repos
import io.reactivex.Single

interface ReposRepository {
    fun getRepos(username: String): Single<List<Repos>>
}