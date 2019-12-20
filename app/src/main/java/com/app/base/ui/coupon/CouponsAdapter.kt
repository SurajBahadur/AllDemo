package com.app.base.ui.coupon

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.base.R
import com.app.base.bean.CouponModel
import com.app.base.bean.CouponModelResponse
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.item_coupon.view.*
import java.text.SimpleDateFormat
import java.util.*


class CouponsAdapter(private val couponsList: ArrayList<CouponModelResponse>, private val context: CouponsActivity, val clickListener: View.OnClickListener) : RecyclerView.Adapter<CouponsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_coupon, parent, false) as MaterialCardView
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
        fun bindItems(coupon: CouponModelResponse, context: CouponsActivity, position: Int, clickListener: View.OnClickListener) {
            /*val displayMetrics = DisplayMetrics()
            (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
            val height = displayMetrics.heightPixels
            itemView.layoutParams.height = height / 3*/

            itemView.tv_coupon_title.text = coupon.couponTitle
            itemView.tv_coupon_link.text = coupon.couponLink
            itemView.tv_coupon_view.text = coupon.couponView.toString()
            itemView.tag = position
            itemView.mcv.setOnClickListener(clickListener)

            //2019-08-03 19:20:47
            val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val date: Date = format.parse(coupon.couponAddedOn)
            val calendar = Calendar.getInstance()
            calendar.time = date

            if (calendar.get(Calendar.HOUR_OF_DAY) < 12) {
                itemView.tv_coupon_addedon.text = calendar.get(Calendar.HOUR_OF_DAY).toString() + ":" + calendar.get(Calendar.MINUTE) + " AM"
            } else {
                val hour = calendar.get(Calendar.HOUR_OF_DAY) - 12
                itemView.tv_coupon_addedon.text = "$hour" + ":" + calendar.get(Calendar.MINUTE) + " PM"
            }


        }
    }


}