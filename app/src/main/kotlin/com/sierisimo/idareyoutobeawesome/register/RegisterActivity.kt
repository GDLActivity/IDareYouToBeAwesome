package com.sierisimo.idareyoutobeawesome.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.sierisimo.idareyoutobeawesome.BuildConfig
import com.sierisimo.idareyoutobeawesome.R
import com.sierisimo.idareyoutobeawesome.home.MainActivity
import com.sierisimo.idareyoutobeawesome.util.SH_PREF_BOOL_IS_LOGGED
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener, FirebaseAuth.AuthStateListener {
    val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setupToolbar()
        btn_ac_register_main.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        firebaseAuth.addAuthStateListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
            else -> super.onOptionsItemSelected(item)
        }

        return true
    }

    override fun onStop() {
        firebaseAuth.removeAuthStateListener(this)
        super.onStop()
    }

    fun setupToolbar() {
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.vector_menubar_back_arrow)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setTitle(R.string.title_dummy)
    }

    override fun onClick(v: View?) {
        when (v) {
            btn_ac_register_main -> if (validate()) startRegister()
        }
    }

    private fun validate(): Boolean {
        return if (tiet_ac_register_email.text.toString().isNullOrBlank()) {
            showError(til_ac_register_email, R.string.error_dummy)
            false
        } else if (tiet_ac_register_password.text.toString().isNullOrBlank() || tiet_ac_register_password.text.toString().length < 8) {
            showError(til_ac_register_password, R.string.error_dummy)
            false
        } else if (tiet_ac_register_password_confirm.text.toString().isNullOrBlank() || tiet_ac_register_password.text.toString() != tiet_ac_register_password.text.toString()) {
            showError(til_ac_register_password_confirm, R.string.error_dummy)
            false
        } else true
    }

    private fun showError(textInputLayout: TextInputLayout, errorId: Int) {
        textInputLayout.isErrorEnabled = true
        textInputLayout.error = getString(errorId)
    }

    private fun startRegister() {
        firebaseAuth.createUserWithEmailAndPassword(tiet_ac_register_email.text.toString(), tiet_ac_register_password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (!task.isSuccessful) {
                        //TODO: 2/6/17 Show a better error
                        Snackbar.make(findViewById(android.R.id.content), " :( :/", Snackbar.LENGTH_SHORT).show()
                        Log.e("RegisterActivity", task.exception?.message)
                    }
                }
    }

    override fun onAuthStateChanged(firebAuth: FirebaseAuth) {
        if (firebAuth.currentUser != null) {
            getSharedPreferences(BuildConfig.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
                    .edit()
                    .putBoolean(SH_PREF_BOOL_IS_LOGGED, true)
                    .apply()

            launchHome()
        } else {
            //TODO: 2/6/17 User Signed out
            Snackbar.make(findViewById(android.R.id.content), ":(", Snackbar.LENGTH_SHORT).show()
        }
    }

    fun launchHome() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}
