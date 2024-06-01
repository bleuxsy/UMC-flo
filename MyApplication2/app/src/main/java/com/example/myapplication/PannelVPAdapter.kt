package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PannelVPAdapter(fragment: Fragment):FragmentStateAdapter(fragment) {
    private val fragmentList : ArrayList<Fragment> = ArrayList()
    override fun getItemCount(): Int {
        return fragmentList.size

    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
    fun addFragment(fragment: Fragment){
        fragmentList.add(fragment)
        notifyItemInserted(fragmentList.size)
    }

}