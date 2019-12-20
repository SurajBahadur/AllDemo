package com.app.base.ui.coupon

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.base.R
import com.app.base.base_classes.BaseActivity
import com.app.base.bean.CouponModel
import com.app.base.bean.CouponModelResponse
import com.google.firebase.firestore.*
import com.thefinestartist.finestwebview.FinestWebView
import kotlinx.android.synthetic.main.activity_coupons.*

class CouponsActivity : BaseActivity(), View.OnClickListener {


    private val db = FirebaseFirestore.getInstance()
    private val couponList = ArrayList<CouponModelResponse>()

    override fun getID(): Int {
        return R.layout.activity_coupons
    }

    override fun iniView(savedInstanceState: Bundle?) {
        shimmerLayout.startShimmerAnimation()
        getCouponsList()
    }

    private fun getCouponsList() {

        db.collection("coupons").addSnapshotListener(EventListener<QuerySnapshot> { snapshots, e ->
            if (e != null) {
                Log.w(TAG, "listen:error", e)
                return@EventListener
            }
            val notesList = mutableListOf<CouponModelResponse>()
            for (doc in snapshots!!) {
                val note = doc.toObject(CouponModelResponse::class.java)
                note.id = doc.id
                notesList.add(note)
            }
            // instead of simply using the entire query snapshot
            // see the actual changes to query results between query snapshots (added, removed, and modified)
            for (dc in snapshots.documentChanges) {
                when (dc.type) {
                    DocumentChange.Type.ADDED -> Log.d(TAG, "New city: " + dc.document.data)
                    DocumentChange.Type.MODIFIED -> {
                        Log.d(TAG, "Modified city: " + dc.document.data)
                        couponList[dc.newIndex].couponView = dc.document.data["couponView"] as Long
                        rv_coupon_list.adapter!!.notifyItemChanged(dc.newIndex)
                    }
                    DocumentChange.Type.REMOVED -> Log.d(TAG, "Removed city: " + dc.document.data)
                }
            }
        })

        db.collection("coupons").get().addOnCompleteListener {
            for (i in 0 until it.result!!.size()) {
                couponList.add(CouponModelResponse(
                        it.result!!.documents[i].id,
                        it.result!!.documents[i]["couponTitle"] as String,
                        it.result!!.documents[i]["couponLink"] as String,
                        it.result!!.documents[i]["couponView"] as Long,
                        it.result!!.documents[i]["couponAddedOn"] as String
                ))
            }
            shimmerLayout.stopShimmerAnimation()
            shimmerLayout.visibility = View.GONE
            val couponsAdapter = CouponsAdapter(couponList, this, this)
            rv_coupon_list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            rv_coupon_list.adapter = couponsAdapter
        }
    }


    override fun onClick(v: View?) {
        db.collection("coupons").document(couponList[v!!.tag as Int].id).update("couponView", FieldValue.increment(1))
        FinestWebView.Builder(this).show("https://www.flipkart.com/")
    }

}
