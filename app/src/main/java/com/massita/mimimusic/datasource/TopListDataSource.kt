package com.massita.mimimusic.datasource

import androidx.paging.ItemKeyedDataSource
import com.massita.mimimusic.api.HearthisService
import com.massita.mimimusic.vo.Feed
import com.massita.mimimusic.vo.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopListDataSource(private val service: HearthisService) : ItemKeyedDataSource<Int, User>() {

    private var pageNumber = 1

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<User>
    ) {
        service.getFeed("popular", pageNumber, params.requestedLoadSize).enqueue(
            object : Callback<List<Feed>> {
                override fun onFailure(call: Call<List<Feed>>, t: Throwable) {
                    // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(call: Call<List<Feed>>, response: Response<List<Feed>>) {
                    pageNumber++
                    val resp = response.body()!!.map { it.user }
                    callback.onResult(resp)
                }

            }
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<User>) {
        service.getFeed("popular", pageNumber, params.requestedLoadSize).enqueue(
            object : Callback<List<Feed>> {
                override fun onFailure(call: Call<List<Feed>>, t: Throwable) {
                    // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(call: Call<List<Feed>>, response: Response<List<Feed>>) {
                    pageNumber++
                    val resp = response.body()!!.map { it.user }
                    callback.onResult(resp)
                }

            }
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<User>) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getKey(item: User): Int {
        return pageNumber
    }
}