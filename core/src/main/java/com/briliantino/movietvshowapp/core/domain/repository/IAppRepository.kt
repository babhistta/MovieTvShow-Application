package com.briliantino.movietvshowapp.core.domain.repository

import com.briliantino.movietvshowapp.core.domain.model.Movie
import com.briliantino.movietvshowapp.core.domain.model.TvShow
import com.briliantino.movietvshowapp.core.vo.Resource
import io.reactivex.Flowable

interface IAppRepository {
    fun getAllMovie(): Flowable<Resource<List<Movie>>>

    fun getAllTvShow(): Flowable<Resource<List<TvShow>>>

    fun getDetailMovie(movieId: Int): Flowable<Resource<Movie>>

    fun getDetailTvShow(tvId: Int): Flowable<Resource<TvShow>>

    fun setMovieFavorite(movie: Movie, state: Boolean)

    fun setTvShowFavorite(tvShow: TvShow, state: Boolean)

    fun getFavoriteMovie(): Flowable<List<Movie>>

    fun getFavoriteTvShow(): Flowable<List<TvShow>>
}