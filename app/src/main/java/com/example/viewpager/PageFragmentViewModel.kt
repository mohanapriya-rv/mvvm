package com.example.viewpager

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class PageFragmentViewModel:ViewModel() {

    val parentDummyData = ArrayList<Options>()

    var parentDummyData1 :ArrayList<SelectedOptions>?=null

    var childOptions:ArrayList<choiceOptions> = ArrayList()

     var _selectedArrayList=ArrayList<SelectedOptions>()

     private val _options = MutableLiveData<List<Options>>()

    val options: LiveData<List<Options>>
        get() = _options

    private val _optionsnew = MutableLiveData<List<SelectedOptions>>()

    val optionsnew: LiveData<List<SelectedOptions>>
        get() = _optionsnew
    init{

        Log.i("cc","viewmodels created")
        createData()
        createData1()
    }
    fun createData() {
        childOptions.add(choiceOptions("Under 30"))
        childOptions.add(choiceOptions("31 - 40"))
        childOptions.add(choiceOptions("41 - 50"))
        childOptions.add(choiceOptions("51 - 60"))
        childOptions.add(choiceOptions("Above 60"))
        childOptions.add(choiceOptions("Not familiar11"))
        childOptions.add(choiceOptions("Very limited knowledge11"))
        childOptions.add(choiceOptions("Basic knowledge and minimal experience11"))
        childOptions.add(choiceOptions("111Good knowledge and some investment experience"))
        childOptions.add(choiceOptions("11111Basic "))
        childOptions.add(choiceOptions("222Notfamiliar"))
        childOptions.add(choiceOptions("Very5555limited knowledge"))
        childOptions.add(choiceOptions("Basic knowledge88888 and minimal experience"))
        childOptions.add(choiceOptions("Good knowledge and 9999some investment experience"))
        childOptions.add(choiceOptions("Basic77777"))
        parentDummyData.add(Options("How old are you?",childOptions))

        childOptions = ArrayList()
        childOptions.add(choiceOptions("No Income/retired"))
        childOptions.add(choiceOptions("Single Income/atleast one dependent"))
        childOptions.add(choiceOptions("Single Income/no dependent"))
        childOptions.add(choiceOptions("Dual Income/atleast one dependent"))
        childOptions.add(choiceOptions("Dual Income/no dependent"))
        parentDummyData.add(Options("Your household can be best described as",childOptions))

        childOptions = ArrayList()
        childOptions.add(choiceOptions("Not familiar"))
        childOptions.add(choiceOptions("Very limited knowledge"))
        childOptions.add(choiceOptions("Basic knowledge and minimal experience"))
        childOptions.add(choiceOptions("Good knowledge and some investment experience"))
        childOptions.add(choiceOptions("Basic "))
        childOptions.add(choiceOptions("Advanced knowledge and extensive experience"))
        parentDummyData.add(Options("How do you rate your knowledge of investments and securities markets in general?",childOptions))


       childOptions = ArrayList()
       childOptions.add(choiceOptions("Not relevant as I have never experienced a stock market decline"))
       childOptions.add(choiceOptions("Sold"))
       childOptions.add(choiceOptions("Held"))
       childOptions.add(choiceOptions("Bought more"))
       childOptions.add(choiceOptions("Bought more and hoped for further declines"))
       childOptions.add(choiceOptions("Basic "))
       childOptions.add(choiceOptions("I am willing to risk temporary short term losses for getting better returns in the long term."))
       parentDummyData.add(Options("During the recent equity market crash, what did you do?",childOptions))


       childOptions = ArrayList()
       childOptions.add(choiceOptions("I want safety of my capital even if it means low returns"))
       childOptions.add(choiceOptions("I want safety of my capital as well as a slightly higher return on my investment"))
       childOptions.add(choiceOptions("I am willing to take moderate risks to get adequate capital appreciation"))
       childOptions.add(choiceOptions("I am willing to take high risks to earn high returns at the cost of capital. "))
       childOptions.add(choiceOptions("I am willing to risk temporary short term losses for getting better returns in the long term."))
       parentDummyData.add(Options("Which of these statements best describes your investing?",childOptions))

       childOptions = ArrayList()
       childOptions.add(choiceOptions("Which risk-return combination would you prefer?"))
       childOptions.add(choiceOptions("FD + 1-2% annual returns with a chance of 20% temporary short term loss at some point"))
       childOptions.add(choiceOptions("FD + 2-3% annual returns with a chance of 30% temporary short term loss at some point"))
       childOptions.add(choiceOptions("FD + 3-5% annual returns with a chance of 40% temporary short term loss at some point"))
        childOptions.add(choiceOptions("Greater than FD + 5% annual returns annual returns with a chance of 60% temporary short term loss at some point"))
       parentDummyData.add(Options("Which long term return - short term risk combination would you prefer?",childOptions))

        childOptions = ArrayList()
       childOptions.add(choiceOptions("< 1 Year"))
       childOptions.add(choiceOptions("1 - 3 years"))
       childOptions.add(choiceOptions("5 - 3 years"))
       childOptions.add(choiceOptions("5 to 10 years "))
       childOptions.add(choiceOptions("10+ years"))
       parentDummyData.add(Options("How long do you plan to hold your investments? (this is your investment horizon)",childOptions))
        _options.value=parentDummyData
    }


fun createData1(){

    parentDummyData1= ArrayList()

    for(i in 0 until parentDummyData.size)
    {
        val childOptions1:ArrayList<String> = ArrayList()
        childOptions1.add(parentDummyData[i].choiceOptions[0].answer)
        parentDummyData1?.add(SelectedOptions(i,i,childOptions1))
    }

    Log.i("aatat",parentDummyData1.toString())

    _optionsnew.value=parentDummyData1
}

    fun getSelectedOptions1(selectedoptionsdata: SelectedOptions) {

        parentDummyData1?.set(selectedoptionsdata.tabPosition,SelectedOptions(selectedoptionsdata.tabPosition,selectedoptionsdata.questionId,selectedoptionsdata.answers))
        Log.i("aaa",parentDummyData1.toString())
        Log.i("testdata",parentDummyData1.toString())
    }
}


