package com.massita.mimimusic.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.massita.mimimusic.datasource.TopListDataSource
import com.massita.mimimusic.vo.User
import org.koin.core.KoinComponent
import org.koin.core.inject

class TopListDataFactory() : DataSource.Factory<Int, User>(), KoinComponent {

    var topListLiveData = MutableLiveData<TopListDataSource>()

    private val topListDataSource: TopListDataSource by inject()

    override fun create(): DataSource<Int, User> {
        topListLiveData.postValue(topListDataSource)
        return topListDataSource
    }

}