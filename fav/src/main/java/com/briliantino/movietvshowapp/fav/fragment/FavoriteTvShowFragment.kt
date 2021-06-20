package com.briliantino.movietvshowapp.fav.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.briliantino.movietvshowapp.ui.detail.DetailActivity
import com.briliantino.movietvshowapp.fav.FavoriteViewModel
import com.briliantino.movietvshowapp.core.ui.TvShowAdapter
import com.briliantino.movietvshowapp.di.FavoriteModuleDependencies
import com.briliantino.movietvshowapp.fav.DaggerFavoriteComponent
import com.briliantino.movietvshowapp.fav.ViewModelFactory
import com.briliantino.movietvshowapp.fav.databinding.FragmentFavoriteMovieBinding
import com.briliantino.movietvshowapp.fav.databinding.FragmentFavoriteTvShowBinding
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteTvShowFragment : Fragment() {


    private var _binding: FragmentFavoriteTvShowBinding? = null
    private val binding get() = _binding as FragmentFavoriteTvShowBinding


    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        factory
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerFavoriteComponent.builder()
            .context(requireContext())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireContext(),
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .injectTvShow(this)
        val adapterTvShow= TvShowAdapter()
        adapterTvShow.onItemClick = {
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_TV_SHOW, it.id)
            startActivity(intent)
        }


        favoriteViewModel.favTvShow.observe(viewLifecycleOwner,{
            if (it.isNotEmpty()){
                adapterTvShow.setTvShow(it)
                adapterTvShow.notifyDataSetChanged()
            }

        })
        with(binding.rvFavoriteTvShow) {
            this.layoutManager = LinearLayoutManager(context)
            this.adapter = adapterTvShow
        }

    }
}