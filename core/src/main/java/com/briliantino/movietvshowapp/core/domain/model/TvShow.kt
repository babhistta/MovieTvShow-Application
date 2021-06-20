package com.briliantino.movietvshowapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShow(

        val id: Int,
        val overview: String,
        val name: String,
        val posterPath: String,
        val voteAverage: Double,
        val voteCount: Int,
        var favorite: Boolean = false

) : Parcelable