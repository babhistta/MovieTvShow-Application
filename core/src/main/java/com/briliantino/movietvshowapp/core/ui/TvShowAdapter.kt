package com.briliantino.movietvshowapp.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.briliantino.movietvshowapp.core.R
import com.briliantino.movietvshowapp.core.databinding.ItemsTvshowBinding
import com.briliantino.movietvshowapp.core.domain.model.TvShow
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {


    private var listTvShows = ArrayList<TvShow>()
    var onItemClick: ((TvShow) -> Unit)? = null

    fun setTvShow(TvShow: List<TvShow>?) {
        if (TvShow == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(TvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding = ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listTvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShows.size


    inner class TvShowViewHolder(private val binding: ItemsTvshowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow) {
            with(binding) {

                tvItemTitle.text = tvShow.name
                tvItemOverview.text = tvShow.overview
                tvItemRating.text = tvShow.voteAverage.toString()
                tvItemVote.text = itemView.resources.getString(R.string.vote, tvShow.voteCount.toString())
                itemView.setOnClickListener {
                    onItemClick?.invoke(tvShow)
                }
                Glide.with(itemView.context)
                        .load("https://image.tmdb.org/t/p/w500/" + tvShow.posterPath)
                        .transform(RoundedCorners(20))
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgItemPoster)
            }
        }
    }
}
