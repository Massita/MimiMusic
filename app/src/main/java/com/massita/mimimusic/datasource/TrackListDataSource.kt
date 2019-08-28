package com.massita.mimimusic.datasource

import androidx.paging.ItemKeyedDataSource
import com.massita.mimimusic.api.HearthisService
import com.massita.mimimusic.vo.Song

class TrackListDataSource(private val service: HearthisService, val permalink: String) : ItemKeyedDataSource<Int, Song>() {

    private var pageNumber = 1

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Song>
    ) {

        service.getArtistTrackList(permalink,"tracks", pageNumber, params.requestedLoadSize)
            .subscribe(
                { feed ->
                    pageNumber++
                    callback.onResult(feed)},
                {  })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Song>) {
        service.getArtistTrackList(permalink,"tracks", pageNumber, params.requestedLoadSize)
            .subscribe(
                { feed ->
                    pageNumber++
                    callback.onResult(feed)},
                {  })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Song>) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getKey(item: Song): Int {
        return pageNumber
    }
}