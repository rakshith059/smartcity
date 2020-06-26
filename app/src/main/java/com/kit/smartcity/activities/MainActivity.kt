package com.kit.smartcity.activities

import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.kit.smartcity.R
import com.kit.smartcity.fragments.HomeFragment
import com.kit.smartcity.utils.AnimationStyles

class MainActivity : BaseActivity() {
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if (isUserLoggedIn())
        addFragment(HomeFragment(), TAG, AnimationStyles.SLIDE_RIGHT.name)
//        else
//            addFragment(LoginFragment(), TAG, AnimationStyles.SLIDE_RIGHT.name)
    }
}
