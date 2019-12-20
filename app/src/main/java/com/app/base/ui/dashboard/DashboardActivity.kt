package com.app.base.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.app.base.R
import com.app.base.base_classes.BaseActivity
import com.app.base.bean.CouponModel
import com.app.base.ui.coupon.CouponsActivity
import com.app.base.utils.Utils
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_dashboard.*
import java.text.SimpleDateFormat
import java.util.*


class DashboardActivity : BaseActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun getID(): Int {
        return R.layout.activity_dashboard
    }

    override fun iniView(savedInstanceState: Bundle?) {
        attachClickListener()
        subscribeToMessagingTopic()
    }

    private fun subscribeToMessagingTopic() {
        /*FirebaseMessaging.getInstance().subscribeToTopic("coupons")
                .addOnCompleteListener { task ->
                    var msg = getString(R.string.msg_subscribed)
                    if (!task.isSuccessful) {
                        msg = getString(R.string.msg_subscribe_failed)
                    }
                    Log.d(TAG, msg)
                    Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
                }*/
    }

    private fun attachClickListener() {
        bt_coupon_post.setOnClickListener {
            Utils.hideKeyboard(this@DashboardActivity)
            if (checkValidation()) {
                val couponModel = CouponModel(et_coupon_title.text.toString(), et_coupon_link.text.toString(), 0, this.getTime()!!)
                db.collection("coupons")
                        .add(couponModel)
                        .addOnSuccessListener {
                            et_coupon_link.text.clear()
                            et_coupon_title.text.clear()
                            showSnackBar("Added Successfully", this@DashboardActivity)
                        }
                        .addOnFailureListener { e ->
                            Log.w(TAG, "Error adding document", e)
                        }
            } else {
                showSnackBar("Please fill details", this@DashboardActivity)
            }
        }


        button2.setOnClickListener {
            val intent = Intent(this, CouponsActivity::class.java)
            startActivity(intent)
        }
    }


    private fun checkValidation(): Boolean {
        if (et_coupon_link.text.isEmpty()) {
            return false
        } else if (et_coupon_title.text.isEmpty()) {
            return false
        }
        return true
    }

    private fun getTime(): String? {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return dateFormat.format(Date()) // Find todays date
    }
}
