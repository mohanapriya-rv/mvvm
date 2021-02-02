package com.example.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class MFQuestionareFragment : Fragment() {

    private lateinit var myRootView: View
    private lateinit var button: Button
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View{
        myRootView= inflater.inflate(R.layout.m_f_questionaries_fragment, container, false)
        return myRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button=myRootView.findViewById(R.id.mf_risk_calculation)
        clickListener()
        super.onActivityCreated(savedInstanceState)
    }

    private fun clickListener() {
        button.setOnClickListener{
        PageFragment().show(requireActivity().supportFragmentManager, "TAG")
        }
    }
}