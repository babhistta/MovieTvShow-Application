package com.briliantino.movietvshowapp.ui.detail

import androidx.lifecycle.*
import com.briliantino.movietvshowapp.core.domain.model.Movie
import com.briliantino.movietvshowapp.core.domain.model.TvShow
import com.briliantino.movietvshowapp.core.domain.usecase.AppUseCase
import com.briliantino.movietvshowapp.core.vo.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val appUseCase: AppUseCase): ViewModel() {

    private val movieId = MutableLiveData<Int>()
    private val tvShowId = MutableLiveData<Int>()
    private val mutableMovie= MutableLiveData<Movie>()
    private val mutableTvShow= MutableLiveData<TvShow>()

    fun setSelectedMovie(movieId: Int) {
        this.movieId.value = movieId
    }
    fun setSelectedTvShow(tvShowId: Int) {
        this.tvShowId.value = tvShowId
    }

    val detailMovie: LiveData<Resource<Movie>> = Transformations.switchMap(movieId){ movie ->
        LiveDataReactiveStreams.fromPublisher(appUseCase.getDetailMovie(movie))
    }
    val detailTvSHow:LiveData<Resource<TvShow>>  = Transformations.switchMap(tvShowId){ tvShow ->
        LiveDataReactiveStreams.fromPublisher(appUseCase.getDetailTvShow(tvShow))
    }


    fun setMovieList(entity: Movie){
        this.mutableMovie.value = entity
    }

    fun setTvShowList(entity: TvShow){
        this.mutableTvShow.value = entity
    }

    fun setFavoriteMovie(movie: Movie, newStatus:Boolean) = appUseCase.setMovieFavorite(movie, newStatus)

    fun setFavoriteTvShow(tvShow: TvShow, newStatus:Boolean) = appUseCase.setTvShowFavorite(tvShow, newStatus)


}