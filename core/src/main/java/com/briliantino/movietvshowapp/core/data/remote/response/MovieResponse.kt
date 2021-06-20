package com.briliantino.movietvshowapp.core.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class MovieResponse(

		@field:SerializedName("results")
		val results: List<MovieResult> = emptyList()

){
	@Parcelize
	data class MovieResult(

			@field:SerializedName("overview")
			val overview: String = "",

			@field:SerializedName("title")
			val title: String = "",

			@field:SerializedName("poster_path")
			val posterPath: String = "",

			@field:SerializedName("vote_average")
			val voteAverage: Double = 0.0,

			@field:SerializedName("id")
			val id: Int = 0,

			@field:SerializedName("vote_count")
			val voteCount: Int= 0
	) : Parcelable
}


