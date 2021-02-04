package com.example.viewpager

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private var tabCount=7
    override fun getItemCount(): Int =tabCount

    override fun createFragment(position: Int): Fragment {
        return PageListFragment(position)
    }

}