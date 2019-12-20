package com.app.base.activity

import android.content.Intent
import android.os.Bundle
import com.app.base.R
import com.app.base.base_classes.BaseActivity
import com.app.base.ui.dashboard.DashboardActivity

class MainActivity : BaseActivity() {

    override fun getID(): Int {
        return R.layout.activity_main
    }

    override fun iniView(savedInstanceState: Bundle?) {
        initViews()
    }

    private fun initViews() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }

}
