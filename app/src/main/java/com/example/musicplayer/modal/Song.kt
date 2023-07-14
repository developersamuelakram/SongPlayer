package com.example.musicplayer.modal

import android.net.Uri
import android.os.Parcel
import android.os.Parcelable

data class Song(
    val id: Long,
    val title: String?,
    val artist: String?,
    val duration: Long,
    val data: String?,
    val image: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readLong(),
        parcel.readString(),
        parcel.readString()

    ) {
    }

    override fun describeContents(): Int {
        return 0

    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
    }

    companion object CREATOR : Parcelable.Creator<Song> {
        override fun createFromParcel(parcel: Parcel): Song {
            return Song(parcel)
        }

        override fun newArray(size: Int): Array<Song?> {
            return arrayOfNulls(size)
        }
    }

}
