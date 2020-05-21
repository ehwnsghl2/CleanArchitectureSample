package com.brandjunhoe.domain.usecase

import com.brandjunhoe.domain.SingleUseCase
import com.brandjunhoe.domain.entity.Repos
import com.brandjunhoe.domain.repository.ReposRepository
import io.reactivex.Single
import javax.inject.Inject

class ReposUseCase @Inject constructor(private val repository: ReposRepository) :
    SingleUseCase<ReposUseCase.Params, List<Repos>> {

    override fun execute(params: Params?): Single<List<Repos>> {
        return params?.let {
            repository.getRepos(params.username)
        } ?: run {
            Single.never<List<Repos>>()
        }
    }

    data class Params(val username: String)

}