package com.brandjunhoe.domain

import io.reactivex.Single

interface SingleUseCase<Params, Type> : UseCase{
    fun execute(params: Params? = null): Single<Type>
}