package com.kit.smartcity.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kit.smartcity.R
import com.kit.smartcity.adapters.OptionListAdapter
import com.kit.smartcity.models.OptionItemModel
import com.kit.smartcity.utils.FIREBASE_DOCUMENT_TIPTUR
import com.kit.smartcity.utils.FIREBASE_TABLE_NAME
import kotlinx.android.synthetic.main.fragment_option_list.*

class OptionListFragment(val optionName: String) : BaseFragment() {
    var optionListAdapter: OptionListAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_option_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.actionBar?.hide()
        setCustomActionBar(optionName)

        fragment_option_list_ll_progress.visibility = View.VISIBLE
        fragment_option_list_rv_list.visibility = View.GONE
        getOptionList()

        optionListAdapter = OptionListAdapter(iFragmentsCallback)
        fragment_option_list_rv_list.adapter = optionListAdapter
    }

    private fun getOptionList() {
        val tipturDocument = firebaseFirestore?.collection(FIREBASE_TABLE_NAME)?.document(FIREBASE_DOCUMENT_TIPTUR)
        tipturDocument
            ?.collection(optionName)
            ?.get()
            ?.addOnSuccessListener { document ->
                fragment_option_list_ll_progress.visibility = View.GONE
                val optionList = ArrayList<OptionItemModel?>()
                document.documents.forEach {
                    Log.d("smartcity/tiptur is ", it.data.toString())
                    val optionItem = it.toObject(OptionItemModel::class.java)
                    optionList.add(optionItem)
                }
                optionListAdapter?.updatelist(optionList)
                optionListAdapter?.notifyDataSetChanged()
                fragment_option_list_rv_list.visibility = View.VISIBLE
            }
    }
}