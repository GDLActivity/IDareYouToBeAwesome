package com.sierisimo.idareyoutobeawesome.register

import android.os.Bundle
import android.support.design.widget.Snackbar
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

    override fun onClick(v: View?) {
        when (v) {
            btn_ac_register_main -> Snackbar.make(findViewById(android.R.id.content), R.string.msg_dummy, Snackbar.LENGTH_SHORT).show()
        }
    }
}
