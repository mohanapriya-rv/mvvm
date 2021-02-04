package com.example.viewpager

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class PageListFragment( val position: Int) : Fragment() {
    private lateinit var myRootView: View
   private  lateinit var optionListAdapter: optionListAdapter
    private lateinit var RecyclerView:RecyclerView
    private lateinit var TextView:TextView

    private val pageFragmentViewModel by viewModels<pageFragmentViewModel>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        myRootView=inflater.inflate(R.layout.fragment_page, container, false)
        return myRootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        createRecyclerViewAdapter()
        observeLiveData()
        pageFragmentViewModel.createData()
//        if(pageFragmentViewModel.parentDummyData1==null)
//        {
            pageFragmentViewModel.createData1()
      //  }
    }

    private fun observeLiveData() {
        pageFragmentViewModel.options.observe(viewLifecycleOwner, { options ->
            updateGoal(options)
        })

    }
    private fun updateGoal(options: List<Options>) {
       optionListAdapter.updateAdapter(options)
        TextView.text=options[position].Questions
    }

    private fun createRecyclerViewAdapter() {
        RecyclerView.apply{
            layoutManager=LinearLayoutManager(context)
            optionListAdapter = optionListAdapter(pageFragmentViewModel,position){ questionId: Int, answerOption:String->
             Log.i("priya",questionId.toString()+"&&&&"+answerOption)

                 val selectedOptions=selectedOptions(tabPosition =questionId,questionId,answers= listOf(answerOption))
                pageFragmentViewModel.getSelectedOptions1(selectedOptions)
               // pageFragmentViewModel.getSelectedOptions(answerOption)
            }

            adapter=optionListAdapter

        }
    }
    private fun init() {
        TextView=myRootView.findViewById(R.id.question)
        RecyclerView=myRootView.findViewById(R.id.rv_options)
    }


}