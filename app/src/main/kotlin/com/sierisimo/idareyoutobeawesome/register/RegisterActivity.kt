package com.sierisimo.idareyoutobeawesome.register

import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import com.sierisimo.idareyoutobeawesome.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setupToolbar()
        setupForm()
        btn_ac_register_main.setOnClickListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
            else -> super.onOptionsItemSelected(item)
        }

        return true
    }

    fun setupToolbar() {
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.vector_menubar_back_arrow)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setTitle(R.string.title_dummy)
    }

    fun setupForm(){
        
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

    }
}
