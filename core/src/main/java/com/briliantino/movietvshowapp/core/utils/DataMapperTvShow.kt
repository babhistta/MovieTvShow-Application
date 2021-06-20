package com.briliantino.movietvshowapp.core.utils

import com.briliantino.movietvshowapp.core.data.local.entity.TvShowEntity
import com.briliantino.movietvshowapp.core.data.remote.response.TvShowResponse
import com.briliantino.movietvshowapp.core.domain.model.TvShow

object DataMapperTvShow {


    fun mapResponsesToEntitiesTvShow(input : List<TvShowResponse.TvShowResult>) :List<TvShowEntity>{
        val tvShowList = ArrayList<TvShowEntity>()
        input.map{
            val tvShow =TvShowEntity(
                    id= it.id,
                    overview = it.overview,
                    name = it.name,
                    posterPath = it.posterPath,
                    voteCount = it.voteCount,
                    voteAverage = it.voteAverage
            )
            tvShowList.add(tvShow)
        }
        return tvShowList
    }
    fun mapEntitiesToDomainTvShow(input: List<TvShowEntity>): List<TvShow> =
            input.map {
                TvShow(
                        id= it.id,
                        overview = it.overview,
                        name = it.name,
                        posterPath = it.posterPath,
                        voteCount = it.voteCount,
                        voteAverage = it.voteAverage,
                        favorite = it.favorite
                )
            }
    fun mapEntitiesToDomainTvShowDetail(input: TvShowEntity): TvShow =

            TvShow(
                    id= input.id,
                    overview = input.overview,
                    name = input.name,
                    posterPath = input.posterPath,
                    voteCount = input.voteCount,
                    voteAverage = input.voteAverage,
                    favorite = input.favorite
            )


    fun mapDomainToEntityTvShow(input: TvShow) = TvShowEntity(
            id= input.id,
            overview = input.overview,
            name = input.name,
            posterPath = input.posterPath,
            voteCount = input.voteCount,
            voteAverage = input.voteAverage,
            favorite = input.favorite
    )




}