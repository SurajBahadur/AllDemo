package com.app.base.ui.call.home

import android.Manifest
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.base.R
import com.app.base.ui.call.CallViewModel
import com.app.base.ui.call.add.AddMemberActivity
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import kotlinx.android.synthetic.main.activity_call_family.*


class CallFamilyActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: CallViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_family)
        setSupportActionBar(toolbar_call_family)
        viewModel = ViewModelProviders.of(this).get(CallViewModel::class.java)
        askCallPermission()
        askNotificationPermission()
        attachObserver()
        viewModel.getAllContacts()

    }

    private fun attachObserver() {
        viewModel.contacts.observe(this, Observer {
            /*if (it.isNotEmpty()) {
                Log.d("tttttttttt", "${it.size}")
                val familyAdapter = CallFamilyAdapter(it, this, this)
                rv_famili_list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false) as RecyclerView.LayoutManager?
                rv_famili_list.adapter = familyAdapter
            }*/
        })

        viewModel.allContacts.observe(this, Observer {
            if (it.isNotEmpty()) {
                Log.d("tttttttttt", "${it.size}")
                val familyAdapter = CallFamilyAdapter(it, this, this)
                rv_famili_list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false) as RecyclerView.LayoutManager?
                rv_famili_list.adapter = familyAdapter
            }
        })
    }

    private fun askNotificationPermission() {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !notificationManager.isNotificationPolicyAccessGranted) {
            val intent = Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
            startActivity(intent)
        }
    }

    private fun askCallPermission() {
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.READ_CALL_LOG
                )
                .withListener(object : MultiplePermissionsListener {
                    override fun onPermissionsChecked(report: MultiplePermissionsReport?) {

                    }

                    override fun onPermissionRationaleShouldBeShown(
                            permissions: MutableList<PermissionRequest>?,
                            token: PermissionToken?
                    ) {
                    }

                }).check()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.setting, menu)

/*
        val menuItem = menu!!.findItem(R.id.action_add)
        val view = menuItem.actionView
        view.setOnClickListener {
            onOptionsItemSelected(menuItem)
        }
*/

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add -> {
                startActivity(Intent(this, AddMemberActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
