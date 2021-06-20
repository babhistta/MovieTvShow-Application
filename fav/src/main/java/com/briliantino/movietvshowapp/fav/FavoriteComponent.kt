package com.briliantino.movietvshowapp.fav

import android.content.Context
import com.briliantino.movietvshowapp.di.FavoriteModuleDependencies
import com.briliantino.movietvshowapp.fav.fragment.FavoriteMovieFragment
import com.briliantino.movietvshowapp.fav.fragment.FavoriteTvShowFragment
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponent {

    fun injectFav(activityFav: FavoriteActivity)
    fun injectMovie(fragmentMovie: FavoriteMovieFragment)
    fun injectTvShow(fragmentTvShow: FavoriteTvShowFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(mapsModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponent
    }

}