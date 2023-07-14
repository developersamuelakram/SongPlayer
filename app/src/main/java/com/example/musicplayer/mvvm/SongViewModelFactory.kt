package com.example.musicplayer.mvvm

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SongViewModelFactory(val repository: SongRepository) : ViewModelProvider.Factory {


    @RequiresApi(Build.VERSION_CODES.R)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SongViewModel::class.java)) {
            return SongViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}