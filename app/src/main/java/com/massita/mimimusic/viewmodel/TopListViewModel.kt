package com.massita.mimimusic.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.massita.mimimusic.factory.TopListDataFactory
import com.massita.mimimusic.vo.User

class TopListViewModel : ViewModel() {

    var topList: LiveData<PagedList<User>>

    private val topListDataFactory = TopListDataFactory()

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(20)
            .setEnablePlaceholders(true)
            .build()

        topList = LivePagedListBuilder<Int, User>(topListDataFactory, config).build()
    }
}