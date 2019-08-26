package com.massita.mimimusic.di

import com.massita.mimimusic.BuildConfig
import com.massita.mimimusic.api.HearthisService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideRetrofit(get()) }
    single { provideHearthisService(get()) }
}

fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api-v2.hearthis.at/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideHearthisService(retrofit: Retrofit): HearthisService = retrofit.create(HearthisService::class.java)