package com.briliantino.movietvshowapp.fav

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.briliantino.movietvshowapp.core.domain.usecase.AppUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val appUseCase: AppUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(appUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}