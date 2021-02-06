package com.example.viewpager

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class PageListFragment( private  val position: Int) : Fragment()
{
    private lateinit var myRootView: View
    private  lateinit var optionsListAdapter: OptionsListAdapter
    private lateinit var RecyclerView:RecyclerView
    private lateinit var TextView:TextView

    private  var pageFragmentViewModel :PageFragmentViewModel ?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        Log.i("ccc","fragment created")
        myRootView=inflater.inflate(R.layout.fragment_page, container, false)

        return myRootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initviewmodel()
        init()
        createRecyclerViewAdapter()
        observeLiveData()
//        pageFragmentViewModel.createData()
////        if(pageFragmentViewModel.parentDummyData1==null)
////        {
//            pageFragmentViewModel.createData1()
//      //  }
    }

    private fun initviewmodel() {

        pageFragmentViewModel=parentFragment?.let {
            ViewModelProvider(it).get(PageFragmentViewModel::class.java)
        }
        Log.i("testviewmodel",pageFragmentViewModel.toString())
    }

    private fun observeLiveData() {
        pageFragmentViewModel?.options?.observe(viewLifecycleOwner, { options ->
            updateGoal(options)
        })

    }
    private fun updateGoal(options: List<Options>)
    {
        optionsListAdapter.updateAdapter(options)
        TextView.text = options[position].Questions
    }


    private fun createRecyclerViewAdapter()
    {
        RecyclerView.apply{

            layoutManager=LinearLayoutManager(context)

            optionsListAdapter = OptionsListAdapter(pageFragmentViewModel!!,position){ questionId: Int, answerOption:String->

                Log.i("priya", "$questionId&&&&$answerOption")

                pageFragmentViewModel?.getSelectedOptions1(SelectedOptions(tabPosition =questionId, questionId = questionId,answers= listOf(answerOption)))
            }

            adapter=optionsListAdapter

        }
    }

    private fun init() {

        TextView=myRootView.findViewById(R.id.question)
        RecyclerView=myRootView.findViewById(R.id.rv_options)

    }


    override fun onDestroy()
    {
        super.onDestroy()
        Log.e("Test1", "onDestroy$position")
    }


    override fun onDetach()
    {
        super.onDetach()
        Log.e("Test2", "onDetach$position")
    }

}