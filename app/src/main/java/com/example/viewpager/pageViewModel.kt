package com.example.viewpager

import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2

class pageViewModel : ViewModel() {


    fun nextClick(viewPager: ViewPager2) {
        viewPager.currentItem = viewPager.currentItem + 1
    }

    fun resetClick(viewPager: ViewPager2) {
        if (viewPager.currentItem == 0) {
            viewPager.currentItem = viewPager.currentItem
        }
        viewPager.currentItem = viewPager.currentItem - 1
    }
}