package com.example.musicplayer.mvvm

import android.content.ContentResolver
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicplayer.MyApplication
import com.example.musicplayer.modal.Song

@RequiresApi(Build.VERSION_CODES.R)
class SongViewModel(private val repository: SongRepository) : ViewModel() {







    fun showtheList(context: Context) : LiveData<List<Song>> {

       return  repository.getAudioFiles(context)


    }
}