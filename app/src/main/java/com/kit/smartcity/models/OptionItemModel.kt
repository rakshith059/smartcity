package com.kit.smartcity.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class OptionItemModel(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("address")
    var address: String? = null,
    @SerializedName("contact_email")
    var contact_email: String? = null,
    @SerializedName("basic_info")
    var basic_info: String? = null,
    @SerializedName("website")
    var website: String? = null,
    @SerializedName("phone_number")
    var phone_number: String? = null
) : Parcelable