package com.brandjunhoe.presentation.ui.movie

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.brandjunhoe.common.createViewModel
import com.brandjunhoe.common.ob
import com.brandjunhoe.common.sceneTransitionAnimation
import com.brandjunhoe.common.toast
import com.brandjunhoe.domain.entity.DomainEntityMovie
import com.brandjunhoe.presentation.BaseActivity
import com.brandjunhoe.presentation.R
import com.brandjunhoe.presentation.databinding.ActivityMovieBinding
import com.brandjunhoe.presentation.ui.detail.MovieDetailActivity
import kotlinx.android.synthetic.main.activity_movie.*
import javax.inject.Inject

class MovieActivity : BaseActivity<ActivityMovieBinding>() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel:  MovieViewModel by lazy {
        createViewModel(factory, MovieViewModel::class.java)
    }
    override val layoutResource: Int
        get() = R.layout.activity_movie

    override fun setupViewDataBinding() {
        viewDataBinding.apply {
            movieViewModel = viewModel
            lifecycleOwner = this@MovieActivity
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ob(viewModel.liveResult, ::result)
    }

    private fun result(result: MovieViewModel.State) {
        when (result) {
            is MovieViewModel.State.AdapterOnClick -> startMovieDetailActivity(result.domainEntityMovie)
            is MovieViewModel.State.ErrorMessage -> toast(getString(result.msg))
        }
    }

    private fun startMovieDetailActivity(domainEntityMovie: DomainEntityMovie) {
        val intent = Intent(this, MovieDetailActivity::class.java).apply {
            putExtra(MovieDetailActivity.EXTRA_MOVIE_DATA, domainEntityMovie)
        }

        startActivity(intent, sceneTransitionAnimation(rv_movies).toBundle())
    }


}