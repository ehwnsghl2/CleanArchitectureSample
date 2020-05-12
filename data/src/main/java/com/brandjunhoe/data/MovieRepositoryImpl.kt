package com.brandjunhoe.data

import com.brandjunhoe.common.networkThreadWithMainThread
import com.brandjunhoe.data.mapper.MoviesMapper
import com.brandjunhoe.domain.entity.DomainEntityMovie
import com.brandjunhoe.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    private val moviesMapper: MoviesMapper,
    private val apiKey: String
) : MovieRepository {
    override fun getMovies(movieId: Int): Single<List<DomainEntityMovie>> {
        return movieService.getMovies(movieId, apiKey)
            .networkThreadWithMainThread()
            .map(moviesMapper::mapFromEntity)
    }
}
