package com.example.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private var tabCount=8
    override fun getItemCount(): Int = tabCount

    override fun createFragment(position: Int): Fragment {
        return PageListFragment(position)
    }
}