package com.briliantino.movietvshowapp.core.di

import com.briliantino.movietvshowapp.core.data.AppRepository
import com.briliantino.movietvshowapp.core.domain.repository.IAppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(appRepository: AppRepository): IAppRepository

}
