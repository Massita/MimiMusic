package com.massita.mimimusic.api

import com.massita.mimimusic.vo.Song
import com.massita.mimimusic.vo.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HearthisService {

    @GET("/feed/")
    fun getFeed(@Query("type") type: String,
                @Query("page") page: Int,
                @Query("count") count: Int) : Single<List<Song>>

    @GET("/{permalink}/")
    fun getArtistDetail(@Path("permalink") permalink: String) : Single<User>

    @GET("/{permalink}/")
    fun getArtistTrackList(@Path("permalink") permalink: String,
                           @Query("type") type: String,
                           @Query("page") page: Int,
                           @Query("count") count: Int) : Single<List<Song>>

}