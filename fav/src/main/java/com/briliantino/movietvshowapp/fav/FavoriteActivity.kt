package com.briliantino.movietvshowapp.fav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.briliantino.movietvshowapp.di.FavoriteModuleDependencies
import com.briliantino.movietvshowapp.fav.databinding.ActivityFavoriteBinding
import dagger.hilt.android.EntryPointAccessors


class FavoriteActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    this,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .injectFav(this)

        val sectionsPagerAdapter = FavoriteSectionsPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Favorite"

    }

    override fun onRestart() {
        super.onRestart()
        finish()
        startActivity(intent)
    }


}