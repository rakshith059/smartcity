package com.kit.smartcity.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kit.smartcity.R
import com.kit.smartcity.models.OptionItemModel
import kotlinx.android.synthetic.main.fragment_option_detail.*

class OptionDetailFragment(val optionItemModel: OptionItemModel?) : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_option_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.actionBar?.hide()
        setCustomActionBar("")

        val name = optionItemModel?.name
        val basicInfo = optionItemModel?.basic_info
        val address = optionItemModel?.address
        val email = optionItemModel?.contact_email
        val phoneNumber = optionItemModel?.phone_number
        val website = optionItemModel?.website

        if (null != name && name.isNotEmpty()) {
            fragment_option_detail_tv_name.visibility = View.VISIBLE
            fragment_option_detail_tv_name.text = optionItemModel?.name
        } else fragment_option_detail_tv_name.visibility = View.GONE

        if (null != basicInfo && basicInfo.isNotEmpty()) {
            fragment_option_detail_ll_basic_info.visibility = View.VISIBLE
            fragment_option_detail_tv_basic_info.text = optionItemModel?.basic_info
        } else fragment_option_detail_ll_basic_info.visibility = View.GONE

        if (null != address && address.isNotEmpty()) {
            fragment_option_detail_ll_address.visibility = View.VISIBLE
            fragment_option_detail_tv_address.text = optionItemModel?.address
        } else fragment_option_detail_ll_address.visibility = View.GONE

        if (null != email && email.isNotEmpty()) {
            fragment_option_detail_ll_email.visibility = View.VISIBLE
            fragment_option_detail_tv_email.text = optionItemModel?.contact_email
        } else fragment_option_detail_ll_email.visibility = View.GONE

        if (null != phoneNumber && phoneNumber.isNotEmpty()) {
            fragment_option_detail_ll_phone_number.visibility = View.VISIBLE
            fragment_option_detail_tv_phone_number.text = optionItemModel?.phone_number
        } else fragment_option_detail_ll_phone_number.visibility = View.GONE

        if (null != website && website.isNotEmpty()) {
            fragment_option_detail_ll_website.visibility = View.VISIBLE
            fragment_option_detail_tv_website.text = optionItemModel?.website
        } else fragment_option_detail_ll_website.visibility = View.GONE

        fragment_option_detail_ll_address.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=$address"))
            startActivity(intent)
        }
        fragment_option_detail_ll_website.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("$website"))
            startActivity(intent)
        }
        fragment_option_detail_ll_phone_number.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null))
            startActivity(phoneIntent)
        }
        fragment_option_detail_ll_email.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:$email"))
            startActivity(intent)
        }
    }
}