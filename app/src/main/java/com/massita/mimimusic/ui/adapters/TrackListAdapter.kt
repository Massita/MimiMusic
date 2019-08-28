package com.massita.mimimusic.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.massita.mimimusic.R
import com.massita.mimimusic.vo.Song
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.track_list_item.view.*

class TrackListAdapter : PagedListAdapter<Song, TrackListAdapter.ViewHolder>(diffCallback) {

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Song>() {
            override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.track_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = getItem(position)
        song?.let {
            holder.bind(it)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(song: Song) {
            itemView.title.text = song.title
            itemView.genre.text = song.genre
            itemView.duration.text = itemView.context.getString(R.string.track_length, song.duration)

            Picasso.get()
                .load(song.artworkUrl)
                .fit()
                .into(itemView.artwork)
        }

    }

}