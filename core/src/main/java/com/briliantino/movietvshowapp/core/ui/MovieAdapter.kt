package com.briliantino.movietvshowapp.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.briliantino.movietvshowapp.core.R
import com.briliantino.movietvshowapp.core.databinding.ItemsMovieBinding
import com.briliantino.movietvshowapp.core.domain.model.Movie
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovies = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setMovie(movie: List<Movie>?) {
        if (movie == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    inner class MovieViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {

                tvItemTitle.text = movie.title
                tvItemOverview.text = movie.overview
                tvItemRating.text = movie.voteAverage.toString()
                tvItemVote.text = itemView.resources.getString(R.string.vote, movie.voteCount.toString())
                itemView.setOnClickListener {
                    onItemClick?.invoke(movie)
                }
                Glide.with(itemView.context)
                        .load("https://image.tmdb.org/t/p/w500/" + movie.posterPath)
                        .transform(RoundedCorners(20))
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgItemPoster)
            }
        }
    }
}