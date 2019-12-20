package com.app.base.utils.views

import android.Manifest
import android.app.Activity

import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

class PermissionHelper(private val context: Activity, private val mCallBacks: PermissionCallBack) {

    fun getPermission() {
        Dexter.withActivity(context)
                .withPermissions(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE

                ).withListener(object : MultiplePermissionsListener {

                    override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                        if (report.areAllPermissionsGranted()) {
                            mCallBacks.granted()

                        } else {
                            mCallBacks.notGranted()
                        }

                    }

                    override fun onPermissionRationaleShouldBeShown(permissions: List<PermissionRequest>, token: PermissionToken) {


                    }
                }).check()
    }

    interface PermissionCallBack {
        fun granted()

        fun notGranted()

    }
}
