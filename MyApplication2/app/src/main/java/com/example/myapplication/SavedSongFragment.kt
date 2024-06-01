package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.chrome.umcflo.SongDatabase
import com.example.myapplication.databinding.FragmentLockerSavedsongBinding
class SavedSongFragment : Fragment() {

    lateinit var songDB: SongDatabase
    lateinit var binding : FragmentLockerSavedsongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLockerSavedsongBinding.inflate(inflater, container, false)

        songDB = SongDatabase.getInstance(requireContext())!!

        return binding.root

    }

    override fun onStart() {
        super.onStart()
        initRecyclerview()
    }

    private fun initRecyclerview(){
        binding.lockerSavedSongRecyclerView.layoutManager = LinearLayoutManager(requireActivity())
        val lockerAlbumRVAdapter =SavedSongRVAdapter()

        lockerAlbumRVAdapter.setMyItemClickListener(object : SavedSongRVAdapter.MyItemClickListener {

            override fun onRemoveAlbum(songId: Int) {
                songDB.songDao().updateIsLikeById(false, songId)
            }
        })
        binding.lockerSavedSongRecyclerView.adapter = lockerAlbumRVAdapter
        lockerAlbumRVAdapter.addSongs(songDB.songDao().getLikedSongs(true) as ArrayList<Song>)
    }
}