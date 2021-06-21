package com.briliantino.movietvshowapp.core.data.remote

import android.annotation.SuppressLint
import android.util.Log
import com.briliantino.movietvshowapp.core.BuildConfig
import com.briliantino.movietvshowapp.core.data.remote.network.ApiResponse
import com.briliantino.movietvshowapp.core.data.remote.network.ApiService
import com.briliantino.movietvshowapp.core.data.remote.response.MovieResponse
import com.briliantino.movietvshowapp.core.data.remote.response.TvShowResponse
import com.briliantino.movietvshowapp.core.utils.EspressoIdlingResource
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService){

    companion object {
        private const val API_KEY = BuildConfig.MOVIES_TOKEN
        private const val LANGUAGE = "en-US"
        private const val CATEGORY = "popular"
        private const val PAGE = 1
    }

    @SuppressLint("CheckResult")
    fun loadDataMovie(): Flowable<ApiResponse<List<MovieResponse.MovieResult>>> {

        val resultData = PublishSubject.create<ApiResponse<List<MovieResponse.MovieResult>>>()
        val client = apiService.getMovieData(CATEGORY, API_KEY, LANGUAGE, PAGE)
        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe ({ response ->
                val dataArray = response.results
                resultData.onNext(if (dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty)
            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }



    @SuppressLint("CheckResult")
    fun loadDataTvSHow() : Flowable<ApiResponse<List<TvShowResponse.TvShowResult>>> {
        EspressoIdlingResource.increment()
        val resultData = PublishSubject.create<ApiResponse<List<TvShowResponse.TvShowResult>>>()
        val client = apiService.getTvShowData(CATEGORY, API_KEY, LANGUAGE, PAGE)
        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe ({ response ->
                val dataArray = response.results
                resultData.onNext(if (dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty)
            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }

    @SuppressLint("CheckResult")
    fun loadDataMovieDetail(movieId : Int) : Flowable<ApiResponse<MovieResponse.MovieResult>> {
        EspressoIdlingResource.increment()
        val resultData = PublishSubject.create<ApiResponse<MovieResponse.MovieResult>>()
        val client = apiService.getMovieData(CATEGORY, API_KEY, LANGUAGE, PAGE)
        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe ({ response ->
                EspressoIdlingResource.decrement()
                    val movieResponse: MovieResponse = response
                    val movies: List<MovieResponse.MovieResult> = movieResponse.results
                    for (result: MovieResponse.MovieResult in movies) {
                        if (result.id == movieId) {
                            EspressoIdlingResource.decrement()
                            resultData.onNext(if (movies.isNotEmpty()) ApiResponse.Success(result) else ApiResponse.Empty)
                        }
                    }

            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }


    @SuppressLint("CheckResult")
    fun loadDataTvShowDetail(tvId : Int) : Flowable<ApiResponse<TvShowResponse.TvShowResult>> {
        EspressoIdlingResource.increment()
        val resultData = PublishSubject.create<ApiResponse<TvShowResponse.TvShowResult>>()
        val client = apiService.getTvShowData(CATEGORY, API_KEY, LANGUAGE, PAGE)
        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe ({ response ->
                EspressoIdlingResource.decrement()
                val tvShowResponse: TvShowResponse = response
                val tvShows: List<TvShowResponse.TvShowResult> = tvShowResponse.results
                for (result: TvShowResponse.TvShowResult in tvShows) {
                    if (result.id == tvId) {
                        EspressoIdlingResource.decrement()
                        resultData.onNext(if (tvShows.isNotEmpty()) ApiResponse.Success(result) else ApiResponse.Empty)
                    }
                }

            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }
}