package com.brandjunhoe.presentation.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.brandjunhoe.domain.entity.DomainEntityMovie
import com.brandjunhoe.presentation.R
import com.brandjunhoe.presentation.ui.movie.MovieViewModel
import com.brandjunhoe.presentation.ui.movie.adapter.DividerItemDecoration
import com.brandjunhoe.presentation.ui.movie.adapter.MovieAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

@BindingAdapter(value = ["movies", "viewModel"])
fun RecyclerView.setupMovies(items: List<DomainEntityMovie>?, vm: MovieViewModel) {
    this.adapter?.let {
        if (it is MovieAdapter) it.setupList(items)
    } ?: run {
        PagerSnapHelper().attachToRecyclerView(this)
        addItemDecoration(DividerItemDecoration(20))
        MovieAdapter(vm, Glide.with(context)).apply {
            this@setupMovies.adapter = this
            setupList(items)
        }
    }
}

@BindingAdapter(value = ["img", "requestManager"])
fun ImageView.movieImage(path: String, manager: RequestManager) {
    manager.load(this.context.getString(R.string.image_base_url) + path)
        .placeholder(R.drawable.img_placeholder)
        .into(this)
}

@BindingAdapter(value = ["detailImage"])
fun ImageView.detailMovieImage(path: String) {
    Glide.with(this).load(this.context.getString(R.string.image_base_url) + path)
        .placeholder(R.drawable.img_placeholder)
        .into(this)
}