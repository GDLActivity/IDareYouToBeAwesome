package com.sierisimo.idareyoutobeawesome.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.sierisimo.idareyoutobeawesome.R
import com.sierisimo.idareyoutobeawesome.home.MainActivity
import com.sierisimo.idareyoutobeawesome.register.RegisterActivity
import com.sierisimo.idareyoutobeawesome.util.ACT_REQ_REGISTER
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    val authInstance = FirebaseAuth.getInstance()!!
    val authListener = FirebaseAuth.AuthStateListener {
        val user = it.currentUser
        if (user != null) {
            // User is signed in
            Log.i("LoginActivity", "onAuthStateChanged:signed_in: ${user.uid}")
        } else {
            // User is signed out
            Log.d("LoginActivity", "onAuthStateChanged:signed_out");
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupView()
    }

    private fun setupView() {
        tv_login_anonymous.setOnClickListener(this)

        acb_login_facebook.setOnClickListener(this)
        acb_login_google.setOnClickListener(this)
        acb_login_twitter.setOnClickListener(this)
        acb_login_email.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        authInstance.addAuthStateListener(authListener)
    }

    override fun onStop() {
        authInstance?.removeAuthStateListener(authListener)
        super.onStop()
    }

    override fun onClick(v: View?) {
        when (v) {
            tv_login_anonymous -> startHome()
            acb_login_email -> startRegister()
            acb_login_facebook, acb_login_google, acb_login_twitter -> startHome()
        }
    }

    private fun startHome() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun startRegister() =
            startActivityForResult(Intent(this, RegisterActivity::class.java), ACT_REQ_REGISTER)
}