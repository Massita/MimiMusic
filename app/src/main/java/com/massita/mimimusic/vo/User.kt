package com.massita.mimimusic.vo

import com.google.gson.annotations.SerializedName

data class User(
    val id: String,
    val permalink: String,
    val username: String,
    val uri: String,
    @SerializedName("permalink_url") val permalinkUrl: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("background_url") val backgroundUrl: String?,
    val description: String?,
    @SerializedName("track_count") val trackCount: Int?
)