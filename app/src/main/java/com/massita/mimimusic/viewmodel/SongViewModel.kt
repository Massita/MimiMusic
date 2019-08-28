package com.massita.mimimusic.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.massita.mimimusic.vo.Song

class SongViewModel : ViewModel() {

    var song = MutableLiveData<Song>()

    fun setSelectedSong(newSong: Song) {
        song.postValue(newSong)
    }

}