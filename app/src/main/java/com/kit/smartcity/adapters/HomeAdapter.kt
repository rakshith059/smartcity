package com.kit.smartcity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.kit.smartcity.R
import com.kit.smartcity.models.SmartCityModel
import com.kit.smartcity.utils.IFragmentsCallback
import com.kit.smartcity.viewholder.HomeItemViewHolder

class HomeAdapter(
    val smartCityOptionsList: ArrayList<SmartCityModel>,
    val iFragmentsCallback: IFragmentsCallback?
) : RecyclerView.Adapter<HomeItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.option_item_row, parent, false)
        return HomeItemViewHolder(view, iFragmentsCallback)
    }

    override fun getItemCount(): Int {
        return smartCityOptionsList.size
    }

    override fun onBindViewHolder(holder: HomeItemViewHolder, position: Int) {
        holder.bind(smartCityOptionsList[position])
    }
}