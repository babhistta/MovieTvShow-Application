package com.briliantino.movietvshowapp.di

import com.briliantino.movietvshowapp.core.domain.usecase.AppUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {

    fun appUseCase(): AppUseCase
}