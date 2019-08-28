package com.massita.mimimusic.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.massita.mimimusic.factory.TrackListDataFactory
import com.massita.mimimusic.vo.Song

class TrackListViewModel(permalink: String) : ViewModel() {

    var trackList: LiveData<PagedList<Song>>

    private val trackListDataFactory = TrackListDataFactory(permalink)

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(20)
            .setEnablePlaceholders(true)
            .build()

        trackList = LivePagedListBuilder<Int, Song>(trackListDataFactory, config).build()
    }
}