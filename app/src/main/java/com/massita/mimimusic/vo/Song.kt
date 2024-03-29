package com.massita.mimimusic.vo

import com.google.gson.annotations.SerializedName

data class Song(
    val id: String,
    val duration: String,
    val genre: String,
    val title: String,
    @SerializedName("artwork_url") val artworkUrl: String,
    @SerializedName("stream_url") val streamUrl: String,
    val user: User
)