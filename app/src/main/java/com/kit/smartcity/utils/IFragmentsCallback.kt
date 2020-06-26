package com.kit.smartcity.utils

import androidx.fragment.app.Fragment

interface IFragmentsCallback {

    fun addFragment(fragment: Fragment, backstack: String?, animationStyles: String)

    fun replaceFragment(fragment: Fragment, backstack: String?, animationStyles: String)
}