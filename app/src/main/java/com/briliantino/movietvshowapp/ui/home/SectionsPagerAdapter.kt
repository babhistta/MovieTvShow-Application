package com.briliantino.movietvshowapp.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.briliantino.movietvshowapp.R
import com.briliantino.movietvshowapp.ui.movie.MovieFragment
import com.briliantino.movietvshowapp.ui.tvshow.TvShowFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tvshow)
    }

    override fun getItem(position: Int): Fragment =
            when (position) {
                0 -> MovieFragment()
                1 -> TvShowFragment()
                else -> Fragment()
            }

    override fun getPageTitle(position: Int): CharSequence = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = TAB_TITLES.size

}