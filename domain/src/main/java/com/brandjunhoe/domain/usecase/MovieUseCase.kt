package com.brandjunhoe.domain.usecase

import com.brandjunhoe.domain.SingleUseCase
import com.brandjunhoe.domain.entity.DomainEntityMovie
import com.brandjunhoe.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class MovieUseCase @Inject constructor(private val movieRepository: MovieRepository) :
    SingleUseCase<MovieUseCase.Params, List<DomainEntityMovie>> {

    override fun execute(params: Params?): Single<List<DomainEntityMovie>> {
        return params?.let {
            movieRepository.getMovies(params.movieId)
        } ?: run {
            Single.never<List<DomainEntityMovie>>()
        }
    }

    data class Params(val movieId: Int)

}