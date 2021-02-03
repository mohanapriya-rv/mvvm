package com.example.viewpager

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView

class optionListAdapter(var pagerposition: Int,private val callback: (String) -> Unit) : RecyclerView.Adapter<optionListAdapter.ViewHolder>(){
    private lateinit var context: Context
    private var items=ArrayList<Options>()
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(answerOption: String) {
             mfOptionText.text=answerOption
        }

        val dividerLine: View = itemView.findViewById(R.id.divider_line)
        var mfOptionText: TextView = itemView.findViewById(R.id.tv_options)
        val mfoptionsRow: ConstraintLayout = itemView.findViewById(R.id.mf_options_row)
        var mfOptionsButton:RadioButton=itemView.findViewById(R.id.rb_options)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.mf_options,
                        parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val  answerOption = items[pagerposition].choiceOptions[position].answer

        holder.bind(answerOption)
        holder.mfoptionsRow.setOnClickListener{
            if(!items[pagerposition].isChecked) {
                items[pagerposition].isChecked = true
                holder.mfOptionsButton.isChecked = true
            }
            else
            {
                items[pagerposition].isChecked = false
                holder.mfOptionsButton.isChecked = false
            }
            callback(answerOption)
        }

        if (holder.position == items[pagerposition].choiceOptions.size - 1) {
            holder.dividerLine.visibility = View.INVISIBLE
        } else {
            holder.dividerLine.visibility = View.VISIBLE
    }
//        if ("Basic"== answerOption) {
//            holder.mfOptionsButton.isChecked = true
//            holder.mfOptionText.setTextColor(ContextCompat.getColor(context, R.color.light_black))
//            holder.mfOptionText.typeface = ResourcesCompat.getFont(context, R.font.open_sans_semibold)
//        } else {
//            holder.mfOptionsButton.isChecked = false
//            holder.mfOptionText.setTextColor(ContextCompat.getColor(context, R.color.bermuda_grey))
//            holder.mfOptionText.typeface = ResourcesCompat.getFont(context, R.font.open_sans)
//        }
    }

    override fun getItemCount(): Int {
        return items[pagerposition].choiceOptions.size
    }

override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
    super.onAttachedToRecyclerView(recyclerView)
    context = recyclerView.context
}

    fun updateAdapter(goal: List<Options>) {
        this.items= goal as ArrayList<Options>
        Log.i("vvvv",items.toString())
        notifyDataSetChanged()
    }


}
