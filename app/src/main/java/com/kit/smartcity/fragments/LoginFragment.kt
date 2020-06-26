package com.kit.smartcity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kit.smartcity.R
import com.kit.smartcity.utils.AnimationStyles
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment() {
    val TAG = LoginFragment::class.java.simpleName
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fragment_login_tv_google_sign_in.setOnClickListener {
            val email = fragment_login_tet_email.text.toString()
            val password = fragment_login_tet_password.text.toString()
            if (isValidUser(email, password))
                registerNewUser(email, password)
        }


    }

    private fun isValidUser(email: String, password: String): Boolean {
        return isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length > 6
    }

    private fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun registerNewUser(email: String, password: String) {
        val auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    UpdateUI(auth.currentUser)
                } else {
                    UpdateUI(null)
                }
            }
    }

    private fun UpdateUI(currentUser: FirebaseUser?) {
        if (null != currentUser) {
            iFragmentsCallback?.replaceFragment(HomeFragment(), TAG, AnimationStyles.SLIDE_RIGHT.name)
        }
    }
}