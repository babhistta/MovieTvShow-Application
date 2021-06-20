package com.briliantino.movietvshowapp.fav

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.briliantino.movietvshowapp.core.domain.usecase.AppUseCase
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(appUseCase: AppUseCase) : ViewModel() {
    val favMovie = LiveDataReactiveStreams.fromPublisher(appUseCase.getFavoriteMovie())
    val favTvShow = LiveDataReactiveStreams.fromPublisher(appUseCase.getFavoriteTvShow())
}