package com.massita.mimimusic

import android.app.Application
import com.massita.mimimusic.di.feedModule
import com.massita.mimimusic.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(networkModule, feedModule))
        }
    }

}