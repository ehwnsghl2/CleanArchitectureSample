package com.brandjunhoe.presentation.ui.movie.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brandjunhoe.common.recyclerViewInflate
import com.brandjunhoe.domain.entity.DomainEntityMovie
import com.brandjunhoe.presentation.R
import com.brandjunhoe.presentation.ui.movie.MovieViewModel
import com.bumptech.glide.RequestManager

class MovieAdapter(
    private val viewModel: MovieViewModel,
    private val glideRequestManager: RequestManager
) : RecyclerView.Adapter<MovieViewHolder>() {

    private var list: List<DomainEntityMovie> = emptyList()

    fun setupList(countries: List<DomainEntityMovie>?) {
        list = countries.orEmpty()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(parent.recyclerViewInflate(R.layout.item_movie))
    }

    override fun getItemCount(): Int = list.count()

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binding.run {
            item = list[position]
            movieViewModel = viewModel
            requestManager = glideRequestManager
        }
    }

    override fun onViewRecycled(holder: MovieViewHolder) {
        glideRequestManager.clear(holder.binding.imgMovie)
        super.onViewRecycled(holder)
    }
}
