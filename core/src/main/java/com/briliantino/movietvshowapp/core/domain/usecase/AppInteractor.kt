package com.briliantino.movietvshowapp.core.domain.usecase

import com.briliantino.movietvshowapp.core.domain.model.Movie
import com.briliantino.movietvshowapp.core.domain.model.TvShow
import com.briliantino.movietvshowapp.core.domain.repository.IAppRepository
import javax.inject.Inject

class AppInteractor @Inject constructor(private val appRepository: IAppRepository) : AppUseCase {
    override fun getAllMovie() = appRepository.getAllMovie()

    override fun getAllTvShow() = appRepository.getAllTvShow()

    override fun getDetailMovie(movieId: Int) = appRepository.getDetailMovie(movieId)

    override fun getDetailTvShow(tvId: Int) = appRepository.getDetailTvShow(tvId)

    override fun setMovieFavorite(movie: Movie, state: Boolean) = appRepository.setMovieFavorite(movie,state)
    override fun setTvShowFavorite(tvShow: TvShow, state: Boolean) = appRepository.setTvShowFavorite(tvShow,state)

    override fun getFavoriteMovie() = appRepository.getFavoriteMovie()

    override fun getFavoriteTvShow() = appRepository.getFavoriteTvShow()
}