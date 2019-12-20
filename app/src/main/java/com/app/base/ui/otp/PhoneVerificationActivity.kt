package com.app.base.ui.otp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.base.R
import kotlinx.android.synthetic.main.activity_phone_verification.*
import kotlinx.android.synthetic.main.received_otp.*
import kotlinx.android.synthetic.main.request_otp.*

class PhoneVerificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_verification)
        attachClickListener()
    }

    private fun attachClickListener() {

        btn_send_otp.setOnClickListener {
            content_request_otp.visibility = View.GONE
            content_received_otp.visibility = View.VISIBLE
        }

        btn_verfiy_otp.setOnClickListener {

        }
    }
}
