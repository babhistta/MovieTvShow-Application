package com.briliantino.movietvshowapp.di

import com.briliantino.movietvshowapp.core.domain.usecase.AppInteractor
import com.briliantino.movietvshowapp.core.domain.usecase.AppUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideAppUseCase(appInteractor: AppInteractor): AppUseCase

}
