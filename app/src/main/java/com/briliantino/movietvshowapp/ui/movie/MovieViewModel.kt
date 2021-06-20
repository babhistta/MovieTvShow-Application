package com.briliantino.movietvshowapp.ui.movie

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.briliantino.movietvshowapp.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(appUseCase: AppUseCase) : ViewModel(){

    val movie = LiveDataReactiveStreams.fromPublisher(appUseCase.getAllMovie())

}