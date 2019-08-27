package com.massita.mimimusic.api

import com.massita.mimimusic.vo.Feed
import com.massita.mimimusic.vo.User
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HearthisService {

    @GET("/feed/")
    fun getFeed(@Query("type") type: String,
                @Query("page") page: Int,
                @Query("count") count: Int) : Single<List<Feed>>

    @GET("/{permalink}/")
    fun getArtistDetail(@Path("permalink") permalink: String) : Single<User>

}