package com.massita.mimimusic.di

import com.massita.mimimusic.datasource.TopListDataSource
import com.massita.mimimusic.viewmodel.TopListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val feedModule = module {

    single { TopListDataSource(get()) }

    viewModel { TopListViewModel() }

}