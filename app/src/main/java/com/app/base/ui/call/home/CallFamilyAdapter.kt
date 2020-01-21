package com.app.base.ui.call.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.app.base.R
import com.app.base.bean.CouponModelResponse
import com.app.base.room.entity.ContactData
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.item_coupon.view.*
import kotlinx.android.synthetic.main.item_family.view.*
import java.text.SimpleDateFormat
import java.util.*


class CallFamilyAdapter(private val couponsList: List<ContactData>, private val context: CallFamilyActivity, val clickListener: CallFamilyActivity) : RecyclerView.Adapter<CallFamilyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_family, parent, false) as ConstraintLayout
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return couponsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(couponsList[position], context, position, clickListener)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bindItems(data: ContactData, context: CallFamilyActivity, position: Int, clickListener: View.OnClickListener) {
            /*val displayMetrics = DisplayMetrics()
            (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
            val height = displayMetrics.heightPixels
            itemView.layoutParams.height = height / 3*/

            itemView.tv_name.text = data.ContactName
            itemView.tv_number.text = data.ContactNumber


        }
    }


}