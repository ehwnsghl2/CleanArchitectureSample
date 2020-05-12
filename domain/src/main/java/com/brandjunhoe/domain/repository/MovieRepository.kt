package com.brandjunhoe.domain.repository

import com.brandjunhoe.domain.entity.DomainEntityMovie
import io.reactivex.Single

interface MovieRepository {
    fun getMovies(movieId: Int): Single<List<DomainEntityMovie>>
}