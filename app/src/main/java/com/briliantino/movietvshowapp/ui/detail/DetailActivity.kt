package com.briliantino.movietvshowapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.briliantino.movietvshowapp.R
import com.briliantino.movietvshowapp.databinding.ActivityDetailBinding
import com.briliantino.movietvshowapp.core.domain.model.Movie
import com.briliantino.movietvshowapp.core.domain.model.TvShow
import com.briliantino.movietvshowapp.core.vo.Status
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private var mId: Int = 0
    private var tvId: Int = 0
    private var state = false
    private lateinit var activityDetailBinding: ActivityDetailBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        val extras = intent.extras
        if (extras != null) {
            mId = extras.getInt(EXTRA_MOVIE)
            tvId = extras.getInt(EXTRA_TV_SHOW)
            if (mId != 0 ) {
                detailViewModel.setSelectedMovie(mId)
                detailViewModel.detailMovie.observe(this) { movie ->
                    when (movie.status) {
                        Status.LOADING -> activityDetailBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if (movie.data != null) {
                            activityDetailBinding.progressBar.visibility = View.GONE
                            movie.data?.let {
                                detailViewModel.setMovieList(it)
                                populateMovie(it)
                                state = it.favorite

                                setFavoriteState(state)
                            }
                        }
                        Status.ERROR -> {
                            activityDetailBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
            else if(tvId  != 0){
                detailViewModel.setSelectedTvShow(tvId)
                detailViewModel.detailTvSHow.observe(this) { tvShow ->
                    when (tvShow.status) {
                        Status.LOADING -> activityDetailBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> if (tvShow.data != null) {
                            activityDetailBinding.progressBar.visibility = View.GONE
                            tvShow.data?.let {
                                detailViewModel.setTvShowList(it)
                                populateTvShow(it)
                                state = it.favorite
                                setFavoriteState(state)
                            }
                        }
                        Status.ERROR -> {
                            activityDetailBinding.progressBar.visibility = View.GONE
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

    }

    private fun setFavoriteState(state: Boolean) {
        if (state) {
            activityDetailBinding.fabFavorite.setImageResource(R.drawable.ic_favorite_filled)
        } else {
            activityDetailBinding.fabFavorite.setImageResource(R.drawable.ic_favorite_outlined)
        }
    }

    private fun populateMovie(movie: Movie) {
        supportActionBar?.title = movie.title
        var statusFavorite = movie.favorite
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500/" + movie.posterPath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf( R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                .into(activityDetailBinding.imgItemPoster)

        activityDetailBinding.tvItemTitle.text = movie.title
        activityDetailBinding.tvItemRating.text = movie.voteAverage.toString()
        activityDetailBinding.tvItemVote.text = resources.getString(R.string.vote, movie.voteCount.toString())
        activityDetailBinding.tvDescription.text = movie.overview

        activityDetailBinding.fabFavorite.setOnClickListener{
            statusFavorite = !statusFavorite
            detailViewModel.setFavoriteMovie(movie,statusFavorite)
            setFavoriteState(state)
            when(state){
                false -> Toast.makeText(this,"Add to Favorite!",Toast.LENGTH_SHORT).show()
                true -> Toast.makeText(this,"Delete From Favorite!",Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun populateTvShow(tvShow: TvShow) {

        supportActionBar?.title = tvShow.name
        var statusFavorite = tvShow.favorite
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500/" + tvShow.posterPath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf( R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(activityDetailBinding.imgItemPoster)

        activityDetailBinding.tvItemTitle.text = tvShow.name
        activityDetailBinding.tvItemRating.text = tvShow.voteAverage.toString()
        activityDetailBinding.tvItemVote.text = resources.getString(R.string.vote, tvShow.voteCount.toString())
        activityDetailBinding.tvDescription.text = tvShow.overview



        activityDetailBinding.fabFavorite.setOnClickListener{
            statusFavorite = !statusFavorite
            detailViewModel.setFavoriteTvShow(tvShow,statusFavorite)
            setFavoriteState(state)
            when(state){
                false -> Toast.makeText(this,"Add to Favorite!",Toast.LENGTH_SHORT).show()
                true -> Toast.makeText(this,"Delete From Favorite!",Toast.LENGTH_SHORT).show()
            }
        }

    }


}

