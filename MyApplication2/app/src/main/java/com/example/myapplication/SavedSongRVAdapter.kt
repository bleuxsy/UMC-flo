package com.example.myapplication

import android.annotation.SuppressLint
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemSongBinding

class SavedSongRVAdapter : RecyclerView.Adapter<SavedSongRVAdapter.ViewHolder>() {

    private val switchStatus = SparseBooleanArray()
    private val songs = ArrayList<Song>()



    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SavedSongRVAdapter.ViewHolder {
        val binding: ItemSongBinding = ItemSongBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedSongRVAdapter.ViewHolder, position: Int) {
        holder.bind(songs[position])
        holder.binding.itemSongMoreIv.setOnClickListener {
            mItemClickListener.onRemoveAlbum(songs[position].id)
            removeSong(position)
        }

        val switch = holder.binding.itemSongSwitch
        switch.isChecked = switchStatus[position]
        switch.setOnClickListener {
            if (switch.isChecked) {
                switchStatus.put(position, true)
            } else {
                switchStatus.put(position, false)
            }
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = songs.size
    inner class ViewHolder(val binding: ItemSongBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(song: Song) {
            binding.itemSongTitleTv.text = song.title
            binding.itemSongSingerTv.text = song.singer
            binding.itemSongImgIv.setImageResource(song.coverImg!!)
        }
    }
    interface MyItemClickListener {
        fun onRemoveAlbum(songId: Int)
    }

    private lateinit var mItemClickListener: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener) {
        this.mItemClickListener = itemClickListener
    }
    @SuppressLint("NotifyDataSetChanged")
    fun addSongs(songs: ArrayList<Song>) {
        this.songs.clear()
        this.songs.addAll(songs)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun removeSong(position: Int) {
        songs.removeAt(position)
        notifyDataSetChanged()
    }


}
