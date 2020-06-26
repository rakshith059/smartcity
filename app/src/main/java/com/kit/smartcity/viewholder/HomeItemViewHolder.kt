package com.kit.smartcity.viewholder

import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kit.smartcity.R
import com.kit.smartcity.models.SmartCityModel
import com.facebook.drawee.view.SimpleDraweeView
import com.google.firebase.firestore.FirebaseFirestore
import com.kit.smartcity.fragments.OptionListFragment
import com.kit.smartcity.utils.AnimationStyles
import com.kit.smartcity.utils.IFragmentsCallback

class HomeItemViewHolder(
    itemView: View,
    private val iFragmentsCallback: IFragmentsCallback?
) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    var ivOptionIcon: SimpleDraweeView? = null
    var tvOptionName: AppCompatTextView? = null

    val TAG = itemView.context::class.java.simpleName

    init {
        ivOptionIcon = itemView.findViewById(R.id.option_item_row_iv_icon)
        tvOptionName = itemView.findViewById(R.id.option_item_row_tv_name)
    }

    fun bind(smartCityModel: SmartCityModel) {
        ivOptionIcon?.setImageDrawable(ContextCompat.getDrawable(itemView.context, smartCityModel.optionImage!!))
        tvOptionName?.text = smartCityModel.optionName

        itemView.setOnClickListener(this)
        itemView.tag = smartCityModel.optionName?.toLowerCase()
    }

    override fun onClick(v: View?) {
        val optionName = v?.tag.toString()
        Log.d("smartcity/tiptur is ", "optionName === $optionName")
        iFragmentsCallback?.replaceFragment(OptionListFragment(optionName), TAG, AnimationStyles.SLIDE_RIGHT.name)
    }
}