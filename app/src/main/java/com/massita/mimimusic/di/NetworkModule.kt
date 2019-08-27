package com.massita.mimimusic.di

import com.massita.mimimusic.BuildConfig
import com.massita.mimimusic.api.HearthisService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideRetrofit() }
    single { provideHearthisService(get()) }
}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api-v2.hearthis.at/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideHearthisService(retrofit: Retrofit): HearthisService = retrofit.create(HearthisService::class.java)