package com.briliantino.movietvshowapp.core.utils

import com.briliantino.movietvshowapp.core.data.local.entity.MovieEntity
import com.briliantino.movietvshowapp.core.data.remote.response.MovieResponse
import com.briliantino.movietvshowapp.core.domain.model.Movie

object DataMapperMovie {
    fun mapResponsesToEntitiesMovie(input : List<MovieResponse.MovieResult>) :List<MovieEntity>{
        val movieList = ArrayList<MovieEntity>()
        input.map{
            val movie = MovieEntity(
                    id= it.id,
                    overview = it.overview,
                    title = it.title,
                    posterPath = it.posterPath,
                    voteCount = it.voteCount,
                    voteAverage = it.voteAverage
            )
            movieList.add(movie)
        }
        return movieList
    }
    fun mapEntitiesToDomainMovie(input: List<MovieEntity>): List<Movie> =
            input.map {
                Movie(
                        id= it.id,
                        overview = it.overview,
                        title = it.title,
                        posterPath = it.posterPath,
                        voteCount = it.voteCount,
                        voteAverage = it.voteAverage,
                        favorite = it.favorite
                )
            }

    fun mapEntitiesToDomainMovieDetail(input: MovieEntity): Movie =
            Movie(
                    id= input.id,
                    overview = input.overview,
                    title = input.title,
                    posterPath = input.posterPath,
                    voteCount = input.voteCount,
                    voteAverage = input.voteAverage,
                    favorite = input.favorite
            )


    fun mapDomainToEntityMovie(input: Movie) = MovieEntity(
            id= input.id,
            overview = input.overview,
            title = input.title,
            posterPath = input.posterPath,
            voteCount = input.voteCount,
            voteAverage = input.voteAverage,
            favorite = input.favorite
    )


}