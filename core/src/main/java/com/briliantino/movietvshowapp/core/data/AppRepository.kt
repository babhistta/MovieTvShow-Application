package com.briliantino.movietvshowapp.core.data

import com.briliantino.movietvshowapp.core.data.local.LocalDataSource
import com.briliantino.movietvshowapp.core.data.local.entity.MovieEntity
import com.briliantino.movietvshowapp.core.data.local.entity.TvShowEntity
import com.briliantino.movietvshowapp.core.data.remote.RemoteDataSource
import com.briliantino.movietvshowapp.core.data.remote.network.ApiResponse
import com.briliantino.movietvshowapp.core.data.remote.response.MovieResponse
import com.briliantino.movietvshowapp.core.data.remote.response.TvShowResponse
import com.briliantino.movietvshowapp.core.domain.model.Movie
import com.briliantino.movietvshowapp.core.domain.model.TvShow
import com.briliantino.movietvshowapp.core.domain.repository.IAppRepository
import com.briliantino.movietvshowapp.core.utils.AppExecutors
import com.briliantino.movietvshowapp.core.utils.DataMapperTvShow
import com.briliantino.movietvshowapp.core.utils.DataMapperMovie
import com.briliantino.movietvshowapp.core.vo.Resource
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
    private val remoteDataSource: RemoteDataSource,
) : IAppRepository{

    override fun getAllMovie(): Flowable<Resource<List<Movie>>> {
        return object :
            NetworkBoundResource<List<Movie>, List<MovieResponse.MovieResult>>(appExecutors) {
            public override fun loadFromDB(): Flowable<List<Movie>> {
                return localDataSource.getAllMovies().map { DataMapperMovie.mapEntitiesToDomainMovie(it) }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): Flowable<ApiResponse<List<MovieResponse.MovieResult>>> {
                return remoteDataSource.loadDataMovie()
            }

            override fun saveCallResult(data: List<MovieResponse.MovieResult>) {
                val movieList = DataMapperMovie.mapResponsesToEntitiesMovie(data)
                localDataSource.insertMovies(movieList)
            }
        }.asFlowable()
    }

    override fun getAllTvShow(): Flowable<Resource<List<TvShow>>> {
        return object :
            NetworkBoundResource<List<TvShow>, List<TvShowResponse.TvShowResult>>(appExecutors) {
            public override fun loadFromDB(): Flowable<List<TvShow>> {

                return localDataSource.getAllTvShows().map { DataMapperTvShow.mapEntitiesToDomainTvShow(it) }
            }

            override fun shouldFetch(data: List<TvShow>?): Boolean {
                return data == null || data.isEmpty()
            }

             override  fun createCall(): Flowable<ApiResponse<List<TvShowResponse.TvShowResult>>> {
                return remoteDataSource.loadDataTvSHow()
            }

             override  fun saveCallResult(data: List<TvShowResponse.TvShowResult>) {
                val tvList = DataMapperTvShow.mapResponsesToEntitiesTvShow(data)
                localDataSource.insertTvShows(tvList)
            }
        }.asFlowable()
    }

    override fun getDetailMovie(movieId: Int): Flowable<Resource<Movie>> {
        return object : NetworkBoundResource<Movie, MovieResponse.MovieResult>(appExecutors) {

            override fun loadFromDB(): Flowable<Movie> {
                return localDataSource.getMovieWithDetail(movieId).map { DataMapperMovie.mapEntitiesToDomainMovieDetail(it) }
            }
            override fun shouldFetch(data: Movie?): Boolean =
                data == null

            override  fun createCall(): Flowable<ApiResponse<MovieResponse.MovieResult>> {
                return remoteDataSource.loadDataMovieDetail(movieId)
            }

            override  fun saveCallResult(data: MovieResponse.MovieResult) {
                val movie = MovieEntity(
                    data.id,
                    data.overview,
                    data.title,
                    data.posterPath,
                    data.voteAverage,
                    data.voteCount,
                    false
                )
                localDataSource.updateMovie(movie)
            }
        }.asFlowable()
    }

    override fun getDetailTvShow(tvId: Int): Flowable<Resource<TvShow>> {
        return object :
            NetworkBoundResource<TvShow, TvShowResponse.TvShowResult>(appExecutors) {
            override fun loadFromDB(): Flowable<TvShow> {
                return localDataSource.getTvShowWithDetail(tvId).map { DataMapperTvShow.mapEntitiesToDomainTvShowDetail(it) }
            }
            override fun shouldFetch(data: TvShow?): Boolean =
                data == null

            override fun createCall(): Flowable<ApiResponse<TvShowResponse.TvShowResult>> {
                return remoteDataSource.loadDataTvShowDetail(tvId)
            }

            override fun saveCallResult(data: TvShowResponse.TvShowResult) {
                val tvShow = TvShowEntity(
                    data.id,
                    data.overview,
                    data.name,
                    data.posterPath,
                    data.voteAverage,
                    data.voteCount,
                    false
                )
                localDataSource.updateTvShow(tvShow)
            }
        }.asFlowable()
    }


    override fun setMovieFavorite(movie: Movie, state: Boolean) {
        val movieEntity = DataMapperMovie.mapDomainToEntityMovie(movie)
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movieEntity, state) }
    }

    override fun setTvShowFavorite(tvShow: TvShow, state: Boolean) {
        val tvSHowEntity = DataMapperTvShow.mapDomainToEntityTvShow(tvShow)
        appExecutors.diskIO().execute { localDataSource.setTvShowFavorite(tvSHowEntity, state) }
    }


    override fun getFavoriteMovie(): Flowable<List<Movie>> {
        return localDataSource.getFavoriteMovies().map { DataMapperMovie.mapEntitiesToDomainMovie(it) }
    }

    override fun getFavoriteTvShow(): Flowable<List<TvShow>> {
        return localDataSource.getFavoriteTvShows().map { DataMapperTvShow.mapEntitiesToDomainTvShow(it) }
    }



}
