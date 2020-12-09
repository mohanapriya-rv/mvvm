package com.example.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MFSchemeSortViewModel : ViewModel() {
    private val repository = Repository()
    private val _sortSchemes = MutableLiveData<MFSortScheme>()
    val sortSchemes: LiveData<MFSortScheme>
        get() = _sortSchemes

    fun getScheme() {
        _sortSchemes.value = repository.SortTypes()

    }

    fun setScheme(value: MFSortScheme) {
        _sortSchemes.postValue(value)
    }


}