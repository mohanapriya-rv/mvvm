package com.example.mvvm


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_mf_sort.*

class MFSchemeSortFragment : Fragment() {
    private lateinit var viewModel: MFSchemeSortViewModel
    private lateinit var schemeSortAdapter: SchemeSortAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(MFSchemeSortViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_mf_sort, container, false)
        recyclerView = view.findViewById(R.id.rv_schemesort_)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            viewModel.getScheme()
        }

    }


    override fun onStart() {
        super.onStart()
        observeLiveData()
        initRecyclerView()
//        Log.i("view", viewModel.getScheme().toString())
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            val sortSchemeAdapter = SchemeSortAdapter()
            this@MFSchemeSortFragment.schemeSortAdapter = sortSchemeAdapter
            adapter = sortSchemeAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun observeLiveData() {

        viewModel.sortSchemes.observe(this.viewLifecycleOwner, { schemes ->
//            if (schemes == null) {
//                viewModel.getScheme()
//            }
            schemeSortAdapter.updateScheme(schemes)
        })
    }


//    fun sortTypes() = MFSortScheme(sortOptions = listOf<MFSchemeSortOption>(
//                MFSchemeSortOption(MFSchemeSortOption.ONE_YEAR_RETURNS),
//                MFSchemeSortOption(MFSchemeSortOption.THREE_YEAR_RETURNS),
//                MFSchemeSortOption(MFSchemeSortOption.FIVE_YEAR_RETURNS),
//                MFSchemeSortOption(MFSchemeSortOption.A_Z),
//                MFSchemeSortOption(MFSchemeSortOption.FI_RATED)
//            ),
//            selectedSortOption = MFSchemeSortOption(MFSchemeSortOption.A_Z)
//        )

}