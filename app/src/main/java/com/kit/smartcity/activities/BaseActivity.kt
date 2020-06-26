package com.kit.smartcity.activities

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.kit.smartcity.R
import com.kit.smartcity.utils.IFragmentsCallback
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

open class BaseActivity : AppCompatActivity(), IFragmentsCallback {
    var mFragment: Fragment? = null
    var currentUser: FirebaseUser? = null

    override fun onStart() {
        super.onStart()
        currentUser = FirebaseAuth.getInstance().currentUser
    }

    fun isUserLoggedIn(): Boolean {
        return currentUser != null
    }

    override fun addFragment(fragment: Fragment, backstack: String?, animationStyles: String) {
        try {
            val fragmentTransaction = addFragmentTransaction(fragment, backstack, animationStyles)
            fragmentTransaction.commit()
        } catch (illegalStateException: IllegalStateException) {
            illegalStateException.printStackTrace()
        }
    }

    override fun replaceFragment(fragment: Fragment, backstack: String?, animationStyles: String) {
        try {
            val fragmentTransaction = replaceFragmentTransaction(fragment, backstack, animationStyles)
            fragmentTransaction.commit()
        } catch (illegalStateException: IllegalStateException) {
            illegalStateException.printStackTrace()
        }
    }

    private fun addFragmentTransaction(fragment: Fragment, backStack: String?, animationStyle: String): FragmentTransaction {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.home_container, fragment, backStack)
        if (null != backStack)
            fragmentTransaction.addToBackStack(backStack)

        mFragment = fragment
        return fragmentTransaction
    }

    private fun replaceFragmentTransaction(fragment: Fragment, backStack: String?, animationStyle: String): FragmentTransaction {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.home_container, fragment, backStack)
        if (null != backStack)
            fragmentTransaction.addToBackStack(backStack)

        mFragment = fragment
        return fragmentTransaction
    }

    override fun onBackPressed() {
        val backStackCount = supportFragmentManager.backStackEntryCount
        if (backStackCount == 1)
            finish()
        else
            super.onBackPressed()
    }
}