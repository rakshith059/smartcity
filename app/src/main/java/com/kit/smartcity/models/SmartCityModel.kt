package com.kit.smartcity.models

import android.graphics.drawable.Drawable
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SmartCityModel(
    var optionName: String? = null,
    var optionImage: Int? = null
) : Parcelable