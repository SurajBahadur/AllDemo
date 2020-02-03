package com.app.base.ui.aroundme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.base.R
import com.app.base.ui.aroundme.bean.DataItem
import com.app.base.ui.aroundme.bean.SubCategoryListItem
import kotlinx.android.synthetic.main.item_around_me.view.*

class AroundMeAdapter(private var mListener: (List<SubCategoryListItem?>?) -> Unit, var data: List<DataItem?>?) : RecyclerView.Adapter<AroundMeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_around_me, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(data!![position])
        holder.itemView.setOnClickListener {
            mListener.invoke(data!![position]!!.subCategoryList)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(model: DataItem?) {
            itemView.tv_category.text = model!!.categoryName
        }
    }
}
