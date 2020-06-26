package com.kit.smartcity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.kit.smartcity.R
import com.kit.smartcity.adapters.HomeAdapter
import com.kit.smartcity.models.SmartCityModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        getSmartCity()

        fragment_home_rv_grid.layoutManager = GridLayoutManager(activity, 3)
        fragment_home_rv_grid.adapter = HomeAdapter(prepareSmartCityOptions(), iFragmentsCallback)
    }

//    private fun getSmartCity() {
//        val tipturDocument = firebaseFirestore?.collection(FIREBASE_TABLE_NAME)?.document(FIREBASE_DOCUMENT_TIPTUR)
//
////        tipturDocument
////            ?.get()
////            ?.addOnCompleteListener(object : OnCompleteListener<QuerySnapshot> {
////                override fun onComplete(document: Task<QuerySnapshot>) {
////                    document.result?.documents
//////                    Log.d("smartcity/tiptur is ", document.result?.data.toString())
//////                    document.result?.documents?.get(0).data?.get("name")
////                }
////            })
//
//
//        tipturDocument
//            ?.collection("hospital")
//            ?.get()
//            ?.addOnSuccessListener { document ->
//                document.documents.forEach {
//                    Log.d("smartcity/tiptur is ", it.data.toString())
//                }
//
//                //                    document.result?.documents?.get(0).data?.get("name")
//            }
////        tipturDocument
////            ?.get()
////            ?.addOnCompleteListener { document ->
////                document.result?.data
////                Log.d("smartcity/tiptur is ", document.result?.data.toString())
////                //                    document.result?.documents?.get(0).data?.get("name")
////            }
//    }

    private fun prepareSmartCityOptions(): ArrayList<SmartCityModel> {
        val smartCityOptionList = ArrayList<SmartCityModel>()
        smartCityOptionList.add(SmartCityModel(resources.getString(R.string.option_college), R.drawable.icon_college))
        smartCityOptionList.add(SmartCityModel(resources.getString(R.string.option_register_office), R.drawable.icon_school))
        smartCityOptionList.add(SmartCityModel(resources.getString(R.string.option_hospital), R.drawable.icon_hospital))
        smartCityOptionList.add(SmartCityModel(resources.getString(R.string.option_bank), R.drawable.icon_bank))
        smartCityOptionList.add(SmartCityModel(resources.getString(R.string.option_police_station), R.drawable.icon_police_station))
        smartCityOptionList.add(SmartCityModel(resources.getString(R.string.option_electricity), R.drawable.icon_library))
        smartCityOptionList.add(SmartCityModel(resources.getString(R.string.option_fire_station), R.drawable.icon_fire_station))
        smartCityOptionList.add(SmartCityModel(resources.getString(R.string.option_railway_station), R.drawable.icon_railway_station))
        smartCityOptionList.add(SmartCityModel(resources.getString(R.string.option_post_office), R.drawable.icon_post_office))
        return smartCityOptionList
    }
}