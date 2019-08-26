package com.massita.mimimusic.di

import com.massita.mimimusic.datasource.TopListDataSource
import org.koin.dsl.module

val feedModule = module {

    single { TopListDataSource(get()) }

}