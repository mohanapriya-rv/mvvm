package com.example.viewpager

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class pageFragmentViewModel:ViewModel() {
    private val _options = MutableLiveData<List<Options>>()
    val options: LiveData<List<Options>>
        get() = _options

   fun createData() {
        val parentDummyData = ArrayList<Options>()
        var childOptions:ArrayList<choiceOptions> = ArrayList()
        childOptions.add(choiceOptions("Not familiar"))
        childOptions.add(choiceOptions("Very limited knowledge"))
        childOptions.add(choiceOptions("Basic knowledge and minimal experience"))
        childOptions.add(choiceOptions("Advanced knowledge and extensive experience"))
        childOptions.add(choiceOptions("Not "))
        childOptions.add(choiceOptions("Very &&&&"))
       childOptions.add(choiceOptions("Basic"))
       childOptions.add(choiceOptions("Basic"))
       childOptions.add(choiceOptions("A"))
       childOptions.add(choiceOptions("I want safety of my capital even if it means low returns"))
       childOptions.add(choiceOptions("I want safety of my capital as well as a slightly higher return on my investment"))
       childOptions.add(choiceOptions("I am willing to take moderate risks to get adequate capital appreciation"))
       childOptions.add(choiceOptions("dddd "))
       childOptions.add(choiceOptions(" &&&&"))
       childOptions.add(choiceOptions("I want safety of my capital even if it means low returns"))
       childOptions.add(choiceOptions("I want safety of my capital as well as a slightly higher return on my investment"))
       childOptions.add(choiceOptions("I am willing to take moderate risks to get adequate capital appreciation"))
       childOptions.add(choiceOptions("dddd "))
       childOptions.add(choiceOptions(" &&&&"))
        parentDummyData.add(Options("How do you rate your knowledge of investments and securities markets in general?",childOptions))

        childOptions = ArrayList()
        childOptions.add(choiceOptions("Not relevant as I have never experienced a stock market decline"))
        childOptions.add(choiceOptions("Sold"))
        childOptions.add(choiceOptions("Held"))
        childOptions.add(choiceOptions("Bought more"))
       childOptions.add(choiceOptions("Basic "))
        parentDummyData.add(Options("During the recent equity market crash, what did you do?",childOptions))

        childOptions = ArrayList()
        childOptions.add(choiceOptions("I want safety of my capital even if it means low returns"))
        childOptions.add(choiceOptions("I want safety of my capital as well as a slightly higher return on my investment"))
        childOptions.add(choiceOptions("I am willing to take moderate risks to get adequate capital appreciation"))
       childOptions.add(choiceOptions(" &&&&"))
       childOptions.add(choiceOptions("Basic "))
        childOptions.add(choiceOptions("I am willing to risk temporary short term losses for getting better returns in the long term."))
       childOptions.add(choiceOptions("Sold"))
       childOptions.add(choiceOptions("Held"))
       childOptions.add(choiceOptions("Bought more"))
       childOptions.add(choiceOptions("Basic "))
       childOptions.add(choiceOptions("Sold"))
       childOptions.add(choiceOptions("Held"))
       childOptions.add(choiceOptions("Bought more"))
       childOptions.add(choiceOptions("Basic "))
        parentDummyData.add(Options("Which of these statements best describes your investing?",childOptions))


       childOptions = ArrayList()
       childOptions.add(choiceOptions("I want safety of my capital even if it means low returns"))
       childOptions.add(choiceOptions("I want safety of my capital as well as a slightly higher return on my investment"))
       childOptions.add(choiceOptions("I am willing to take moderate risks to get adequate capital appreciation"))
       childOptions.add(choiceOptions("dddd "))
       childOptions.add(choiceOptions(" &&&&"))
       childOptions.add(choiceOptions("Basic "))
       childOptions.add(choiceOptions("I am willing to risk temporary short term losses for getting better returns in the long term."))
       parentDummyData.add(Options("Which of these statements best describes your investing?",childOptions))


       childOptions = ArrayList()
       childOptions.add(choiceOptions("I want safety of my capital even if it means low returns"))
       childOptions.add(choiceOptions("I want safety of my capital as well as a slightly higher return on my investment"))
       childOptions.add(choiceOptions("I am willing to take moderate risks to get adequate capital appreciation"))
       childOptions.add(choiceOptions("dddd "))
       childOptions.add(choiceOptions(" &&&&"))
       childOptions.add(choiceOptions("Basic "))
       childOptions.add(choiceOptions("I am willing to risk temporary short term losses for getting better returns in the long term."))
       parentDummyData.add(Options("Which of these statements best describes your investing?",childOptions))

       childOptions = ArrayList()
       childOptions.add(choiceOptions("I want safety of my capital even if it means low returns"))
       childOptions.add(choiceOptions("I want safety of my capital as well as a slightly higher return on my investment"))
       childOptions.add(choiceOptions("I am willing to take moderate risks to get adequate capital appreciation"))
       childOptions.add(choiceOptions("I am willing to risk temporary short term losses for getting better returns in the long term."))
       parentDummyData.add(Options("Which of these statements best describes your investing?",childOptions))



       childOptions = ArrayList()
       childOptions.add(choiceOptions("I want safety of my capital even if it means low returns"))
       childOptions.add(choiceOptions("I want safety of my capital as well as a slightly higher return on my investment"))
       childOptions.add(choiceOptions("I am willing to take moderate risks to get adequate capital appreciation"))
       childOptions.add(choiceOptions("dddd "))
       childOptions.add(choiceOptions("I am willing to risk temporary short term losses for getting better returns in the long term."))
       parentDummyData.add(Options("Which of these statements best describes your investing?",childOptions))

       childOptions = ArrayList()
       childOptions.add(choiceOptions("I want safety of my capital as well as a slightly higher return on my investment"))
       childOptions.add(choiceOptions("I am willing to take moderate risks to get adequate capital appreciation"))
       childOptions.add(choiceOptions("I am willing to risk temporary short term losses for getting better returns in the long term."))
       parentDummyData.add(Options("Which of these statements best describes your investing?",childOptions))

       _options.value=parentDummyData

    }

}


