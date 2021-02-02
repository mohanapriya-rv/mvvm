package com.example.viewpager
data class Options(
        var Questions:String,
      val choiceOptions: List<choiceOptions>
)
data class choiceOptions(
        var answer:String,
)