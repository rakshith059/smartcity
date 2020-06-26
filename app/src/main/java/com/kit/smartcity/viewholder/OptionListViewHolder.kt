package com.kit.smartcity.viewholder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.kit.smartcity.R
import com.kit.smartcity.fragments.OptionDetailFragment
import com.kit.smartcity.models.OptionItemModel
import com.kit.smartcity.utils.AnimationStyles
import com.kit.smartcity.utils.IFragmentsCallback

class OptionListViewHolder(itemView: View, val iFragmentsCallback: IFragmentsCallback?) : RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.findViewById<AppCompatTextView>(R.id.option_list_tv_name)
    val tvAddress = itemView.findViewById<AppCompatTextView>(R.id.option_list_tv_address)
    val tvPhoneNumber = itemView.findViewById<AppCompatTextView>(R.id.option_list_tv_phone_number)
    val TAG = itemView.context::class.java.simpleName

    fun bind(optionItemModel: OptionItemModel?) {
        tvName.text = optionItemModel?.name?.trim() ?: ""
        tvAddress.text = optionItemModel?.address?.trim() ?: ""
        tvPhoneNumber.text = optionItemModel?.phone_number?.trim() ?: ""

        itemView.setOnClickListener {
            iFragmentsCallback?.replaceFragment(OptionDetailFragment(optionItemModel), TAG, AnimationStyles.SLIDE_RIGHT.name)
        }
    }
}