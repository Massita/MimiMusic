package com.massita.mimimusic.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.massita.mimimusic.R
import com.massita.mimimusic.vo.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.top_list_item.view.*

class TopListAdapter : PagedListAdapter<User, TopListAdapter.ViewHolder> (diffCallback) {

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<User>() {
            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.top_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        user?.let {
            holder.bind(it)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User) {
            itemView.userName.text = user.username
            itemView.trackCount.text = itemView.context.getString(R.string.track_count, user.trackCount)

            Picasso.get()
                .load(user.avatarUrl)
                .fit()
                .into(itemView.userAvatar)
        }

    }

}


