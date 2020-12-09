package com.example.mvvm

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SchemeSortAdapter : RecyclerView.Adapter<SchemeSortAdapter.SchemeSortViewHolder>() {
    private  var viewModel: MFSchemeSortViewModel= MFSchemeSortViewModel()
    private var items = MFSortScheme(
        listOf(),(MFSchemeSortOption(MFSchemeSortOption.A_Z))
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchemeSortViewHolder {
        System.out.println(items)
        Log.i("view", "oncreate")
        val viewHolder = SchemeSortViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.mf_schemesort_row, parent, false)
        )
        viewHolder.itemView.setOnClickListener { itemView ->
            items.selectedSortOption = items.sortOptions[viewHolder.adapterPosition]
         //   viewModel.setScheme(items)
            notifyDataSetChanged()

        }
//        viewHolder.itemview.setOnClickListener {
//                itemView ->
//            items.selectedSortOption =
//                items.sortOptions[viewHolder.adapterPosition]
//            print(items.sortOptions[viewHolder.adapterPosition])
//            Log.i("oncreate", viewHolder.adapterPosition.toString())
//            notifyDataSetChanged()
//        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: SchemeSortViewHolder, position: Int) {

        Log.i("view", "onBindViewHolder")

        val scheme = items.sortOptions
        System.out.println(scheme)
//        holder.bind(scheme[position],items[0].selectedSortOption.equals(scheme[position].schemeOption))
        holder.bind(
            scheme[position],
            items.selectedSortOption.schemeOption.equals(scheme[position].schemeOption)
        )
        Log.i("aaa", items.selectedSortOption.schemeOption)
        Log.i("aaaa", scheme[position].schemeOption)


    }

    override fun getItemCount(): Int {
        Log.i("bb", items.sortOptions.toString())
        return items.sortOptions.size
    }

    fun updateScheme(sortSchemes: MFSortScheme) {
        Log.i("view", "updateScheme")
        viewModel.setScheme(items)
        items = sortSchemes
        notifyDataSetChanged()
    }

    class SchemeSortViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        private var selectedOrNonselected: ImageView = itemview.findViewById(R.id.iv_nonselected)
        private var sortSchemeText: TextView = itemview.findViewById(R.id.tv_sorttext)

        fun bind(sortScheme: MFSchemeSortOption, selected: Boolean) {
            Log.i("view", "bindScheme")
            Log.i("view1", sortScheme.schemeOption)
            sortSchemeText.text = sortScheme.schemeOption
            if (selected) {
                selectedOrNonselected.setImageResource(R.drawable.ic_selectedradiobutton)
            } else {
                selectedOrNonselected.setImageResource(R.drawable.ic_notselectedradiobutton)
            }
        }

    }

}

