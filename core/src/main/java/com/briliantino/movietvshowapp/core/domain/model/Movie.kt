package com.briliantino.movietvshowapp.core.domain.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(

        val id: Int,
        val overview: String,
        val title: String,
        val posterPath: String,
        val voteAverage: Double,
        val voteCount: Int,
        var favorite: Boolean = false

) : Parcelable