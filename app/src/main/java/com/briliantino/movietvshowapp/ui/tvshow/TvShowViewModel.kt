package com.briliantino.movietvshowapp.ui.tvshow

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.briliantino.movietvshowapp.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(appUseCase: AppUseCase) : ViewModel(){

    val tvShow = LiveDataReactiveStreams.fromPublisher(appUseCase.getAllTvShow())
}

