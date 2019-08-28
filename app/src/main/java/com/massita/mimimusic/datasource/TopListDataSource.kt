package com.massita.mimimusic.datasource

import androidx.paging.ItemKeyedDataSource
import com.massita.mimimusic.api.HearthisService
import com.massita.mimimusic.vo.User

class TopListDataSource(private val service: HearthisService) : ItemKeyedDataSource<Int, User>() {

    private var pageNumber = 1

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<User>
    ) {

        service.getFeed("popular", pageNumber, params.requestedLoadSize)
            .map { response ->
                response.map { service.getArtistDetail(it.user.permalink).blockingGet() }
            }.subscribe(
            { feed ->
                pageNumber++
                callback.onResult(feed)},
            {  })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<User>) {
        service.getFeed("popular", pageNumber, params.requestedLoadSize)
            .map { response ->
                response.map { service.getArtistDetail(it.user.permalink).blockingGet() }
            }.subscribe(
                { feed ->
                    pageNumber++
                    callback.onResult(feed)},
                {  })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<User>) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getKey(item: User): Int {
        return pageNumber
    }
}