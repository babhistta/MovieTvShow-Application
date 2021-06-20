package com.briliantino.movietvshowapp.core.data.remote.network

import com.briliantino.movietvshowapp.core.data.remote.response.MovieResponse
import com.briliantino.movietvshowapp.core.data.remote.response.TvShowResponse
import io.reactivex.Flowable
import retrofit2.http.*

interface ApiService {

    @GET("3/movie/{category}")
     fun getMovieData(
        @Path("category") category: String,
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Flowable<MovieResponse>

    @GET("3/tv/{category}")
     fun getTvShowData(
            @Path("category") category: String,
            @Query("api_key") api_key: String,
            @Query("language") language: String,
            @Query("page") page: Int
    ): Flowable<TvShowResponse>

}