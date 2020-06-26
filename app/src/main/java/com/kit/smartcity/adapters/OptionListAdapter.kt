package com.kit.smartcity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kit.smartcity.R
import com.kit.smartcity.models.OptionItemModel
import com.kit.smartcity.utils.IFragmentsCallback
import com.kit.smartcity.viewholder.OptionListViewHolder

class OptionListAdapter(val iFragmentsCallback: IFragmentsCallback?) : RecyclerView.Adapter<OptionListViewHolder>() {
    var optionItemList = ArrayList<OptionItemModel?>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.option_list_item, parent, false)
        return OptionListViewHolder(view, iFragmentsCallback)
    }

    override fun getItemCount(): Int {
        return optionItemList.size
    }

    override fun onBindViewHolder(holder: OptionListViewHolder, position: Int) {
        holder.bind(optionItemList.get(position))
    }

    fun updatelist(optionItemList: ArrayList<OptionItemModel?>) {
        this.optionItemList = optionItemList
    }

}