package com.massita.mimimusic.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.massita.mimimusic.datasource.TrackListDataSource
import com.massita.mimimusic.vo.Song
import org.koin.core.KoinComponent
import org.koin.core.get

class TrackListDataFactory(val permalink: String) : DataSource.Factory<Int, Song>(), KoinComponent {

    var topListLiveData = MutableLiveData<TrackListDataSource>()

    private lateinit var trackListDataSource: TrackListDataSource

    override fun create(): DataSource<Int, Song> {
        trackListDataSource = TrackListDataSource(get(), permalink)
        topListLiveData.postValue(trackListDataSource)
        return trackListDataSource
    }
}