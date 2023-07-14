package com.example.musicplayer.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.R
import com.example.musicplayer.modal.Song

class SongAdapter : RecyclerView.Adapter<SongHolder>()  {
    var songList = listOf<Song>()

    private var onsongitemlistener : onSongItemClicked? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.songlistitem, parent, false)


        return SongHolder(view)

    }

    override fun getItemCount(): Int {

        return songList.size
    }

    override fun onBindViewHolder(holder: SongHolder, position: Int) {

        val song = songList[position]

        holder.songName.text = song.title
        holder.songArtistName.text = song.artist!!



        val uri = Uri.parse(song.image)

        if (uri!=null){

            holder.imageView.setImageURI(uri)

        } else {
            holder.imageView.setImageResource(R.drawable.album)


        }



        val minutes = song.duration / 60000
        val seconds = song.duration % 60
        val time = "$minutes:$seconds"

        holder.songDuration.text = time

        holder.itemView.setOnClickListener {

            onsongitemlistener?.onSongClicked(position, song)

        }



    }

    fun setList(list: List<Song>){
        this.songList = list
    }

    fun setClickListener(listener: onSongItemClicked){
        this.onsongitemlistener = listener
    }

    fun getItem(position: Int): Song {
        return songList[position]
    }
}

class SongHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

     val imageView : ImageView = itemView.findViewById(R.id.songImageList)
     val songName : TextView = itemView.findViewById(R.id.songNameList)
    val songArtistName : TextView = itemView.findViewById(R.id.artistNameList)
    val songDuration : TextView = itemView.findViewById(R.id.songDurationList)




}

interface onSongItemClicked{
    fun onSongClicked(position: Int, song: Song)
}