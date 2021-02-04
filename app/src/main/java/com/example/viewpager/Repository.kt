package com.example.viewpager

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class Repository:Fragment() {
    private val pageFragmentViewModel by viewModels<pageFragmentViewModel>()
    init{
        Log.i("selectedlist",pageFragmentViewModel._selectedArrayList.toString())
    }
}