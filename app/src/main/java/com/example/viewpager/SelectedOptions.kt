package com.example.viewpager


data class SelectedOptions (
        var tabPosition:Int=-1,
        var questionId:Int,
        var answers:List<String>)