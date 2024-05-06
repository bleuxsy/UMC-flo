package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentSongBinding

class SongFragment : Fragment() {
    private lateinit var binding: FragmentSongBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongBinding.inflate(inflater, container, false)
        setupToggleListeners()
        return binding.root
    }

    private fun setupToggleListeners() {

        binding.songMixoffTg.setOnClickListener {
            toggleMixViews()
        }


        binding.songMixonTg.setOnClickListener {
            toggleMixViews()
        }
    }

    private fun toggleMixViews() {
        if (binding.songMixonTg.visibility == View.GONE) {

            binding.songMixonTg.visibility = View.VISIBLE
            binding.songMixoffTg.visibility = View.GONE
        } else {

            binding.songMixonTg.visibility = View.GONE
            binding.songMixoffTg.visibility = View.VISIBLE
        }
    }
}
