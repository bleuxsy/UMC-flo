package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentBannerBinding
import com.example.myapplication.databinding.FragmentDetailBinding
import com.example.myapplication.databinding.FragmentVideoBinding

class VideoFragment : Fragment() {
    lateinit var binding: FragmentVideoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentVideoBinding.inflate(inflater,container,false)
        return binding.root
    }
}