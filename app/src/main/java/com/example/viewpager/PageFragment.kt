
package com.example.viewpager

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class PageFragment : BottomSheetDialogFragment()
{

    private lateinit var viewPager: ViewPager2
    private lateinit var myRootView: View
    private lateinit var pagerAdapter: PageAdapter
    private lateinit var Button:Button
    private lateinit var Button1:Button
    private lateinit var linearLayout: LinearLayout
    private lateinit var bottomSheetDialog: BottomSheetDialog
    private val pageViewModel  by viewModels<pageViewModel>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {

        myRootView= inflater.inflate(R.layout.fragment_page_list, container, false)
        viewPager=myRootView.findViewById(R.id.mf_questions_view_pager)
        Button=myRootView.findViewById(R.id.btn_next)
        Button1=myRootView.findViewById(R.id.btn_back)


        val tabLayout = myRootView.findViewById<TabLayout>(R.id.mf_questions_tab)

        initViews()

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val tabView: View = LayoutInflater.from(requireActivity()).inflate(R.layout.tab_custom_view, myRootView as ViewGroup, false)
            tab.customView = tabView
        }.attach()

        Button.setOnClickListener {
           pageViewModel.nextClick(viewPager)
          // viewPager.currentItem = viewPager.currentItem + 1
        }
        Button1.setOnClickListener {
         pageViewModel.resetClick(viewPager)
//            if(viewPager.currentItem==0)
//            {
//                viewPager.currentItem = viewPager.currentItem
//            }
//            viewPager.currentItem = viewPager.currentItem-1
        }
        return myRootView
    }

    private fun initViews() {

        pagerAdapter = PageAdapter(this)
        viewPager.adapter = pagerAdapter

    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {

        bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        bottomSheetDialog.setOnShowListener {
            val bottomSheetInternal = bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)

            val behavior = BottomSheetBehavior.from(bottomSheetInternal as View)
            behavior.skipCollapsed = true
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
        return bottomSheetDialog
    }
}