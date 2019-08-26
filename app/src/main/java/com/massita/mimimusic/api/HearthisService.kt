package com.massita.mimimusic.api

import com.massita.mimimusic.vo.Feed
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HearthisService {

    @GET("/feed/")
    fun getFeed(@Query("type") type: String,
                @Query("page") page: Int,
                @Query("count") count: Int) : Call<List<Feed>>


}