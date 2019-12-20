package com.app.base.ui.category.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.base.R
import com.app.base.ui.category.ItemClickListener
import com.app.base.ui.category.pojo.CategoryItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_category_item.view.*

class CategoryItemAdapter(internal var data: ArrayList<CategoryItem>, internal var activity: Context?) : RecyclerView.Adapter<CategoryItemAdapter.ViewHolder>() {

    var listener: ItemClickListener = activity as ItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_category_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data[position].let { holder.bindItem(it) }
        holder.itemView.cl_root.setOnClickListener {
            listener.onItemClick(position, data[position].siteUrl.toString())
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindItem(data: CategoryItem) {
            itemView.tv_site_name.text = data.siteName
            Picasso.get().load("https://www.google.com/s2/favicons?domain=${data.siteUrl}").into(itemView.iv_site_image)
        }
    }
}
