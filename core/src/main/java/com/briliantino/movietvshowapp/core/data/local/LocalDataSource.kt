package com.briliantino.movietvshowapp.core.data.local

import com.briliantino.movietvshowapp.core.data.local.entity.MovieEntity
import com.briliantino.movietvshowapp.core.data.local.entity.TvShowEntity
import com.briliantino.movietvshowapp.core.data.local.room.AppDao
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val mAppAppDao: AppDao) {

    fun getAllMovies(): Flowable<List<MovieEntity>> = mAppAppDao.getMovies()
    fun getAllTvShows(): Flowable<List<TvShowEntity>> = mAppAppDao.getTvShows()

    fun getFavoriteMovies(): Flowable<List<MovieEntity>> = mAppAppDao.getFavoriteMovie()
    fun getFavoriteTvShows(): Flowable<List<TvShowEntity>> = mAppAppDao.getFavoriteTvShow()

    fun insertMovies(movies: List<MovieEntity>) = mAppAppDao.insertMovies(movies)
    fun insertTvShows(tvShows: List<TvShowEntity>) = mAppAppDao.insertTvShows(tvShows)

    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        mAppAppDao.updateMovie(movie)
    }
    fun setTvShowFavorite(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.favorite = newState
        mAppAppDao.updateTvShow(tvShow)
    }

    fun getMovieWithDetail(movieId: Int): Flowable<MovieEntity> =
        mAppAppDao.getMovieById(movieId)
    fun getTvShowWithDetail(tvId: Int): Flowable<TvShowEntity> =
        mAppAppDao.getTvShowById(tvId)

    //
    fun updateMovie(movie: MovieEntity) {
        mAppAppDao.updateMovie(movie)
    }
    fun updateTvShow(tvShow: TvShowEntity) {
        mAppAppDao.updateTvShow(tvShow)
    }

}