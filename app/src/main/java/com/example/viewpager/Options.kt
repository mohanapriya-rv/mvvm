package com.example.viewpager
data class Options(
        var Questions:String,
      val choiceOptions: List<choiceOptions>,
        var isChecked:Boolean=false
)
data class choiceOptions(
        var answer:String,
)