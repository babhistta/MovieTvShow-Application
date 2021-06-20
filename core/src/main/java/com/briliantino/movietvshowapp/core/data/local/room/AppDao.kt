package com.briliantino.movietvshowapp.core.data.local.room

import androidx.room.*
import com.briliantino.movietvshowapp.core.data.local.entity.MovieEntity
import com.briliantino.movietvshowapp.core.data.local.entity.TvShowEntity
import io.reactivex.Flowable

@Dao
interface AppDao {

    @Query("SELECT * FROM movieentities")
    fun getMovies(): Flowable<List<MovieEntity>>

    @Query("SELECT * FROM tvshowentities")
    fun getTvShows(): Flowable<List<TvShowEntity>>

    @Query("SELECT * FROM movieentities where favorite = 1")
    fun getFavoriteMovie(): Flowable<List<MovieEntity>>

    @Query("SELECT * FROM tvshowentities where favorite = 1")
    fun getFavoriteTvShow(): Flowable<List<TvShowEntity>>


    @Transaction
    @Query("SELECT * FROM movieentities WHERE id = :movieId")
    fun getMovieById(movieId: Int): Flowable<MovieEntity>

    @Transaction
    @Query("SELECT * FROM tvshowentities WHERE id = :tvId")
    fun getTvShowById(tvId: Int): Flowable<TvShowEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertTvShows(tvShows: List<TvShowEntity>)


    @Update
    fun updateMovie(movies: MovieEntity)

    @Update
    fun updateTvShow(tvShows: TvShowEntity)



}