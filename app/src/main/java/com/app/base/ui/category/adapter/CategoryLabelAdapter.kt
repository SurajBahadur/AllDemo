package com.app.base.ui.category.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.base.R
import com.app.base.ui.category.pojo.CategorySectionModel
import kotlinx.android.synthetic.main.item_category_name.view.*

class CategoryLabelAdapter(internal var data: ArrayList<CategorySectionModel>?, internal var activity: Context) : RecyclerView.Adapter<CategoryLabelAdapter.ViewHolder>(), Filterable {


    val originalList = data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_category_name, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data?.get(position)?.let { holder.bindItem(it) }
        holder.itemView.rv_category_item_list.setHasFixedSize(true)
        holder.itemView.rv_category_item_list.isNestedScrollingEnabled = false

        holder.itemView.rv_category_item_list.layoutManager = GridLayoutManager(activity, 4)
        val adapter = CategoryItemAdapter(this.data!![position].categoryItemList, activity)
        holder.itemView.rv_category_item_list.adapter = adapter
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindItem(data: CategorySectionModel) {
            itemView.tv_category_name.text = data.categoryLabel
        }
    }

    override fun getFilter(): Filter? {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence): FilterResults {
                val results = FilterResults()
                if (constraint.isEmpty()) {
                    //no filter implemented we return full list
                    results.values = data
                    results.count = data!!.size
                } else {
                    //Here we perform filtering operation
                    val list: ArrayList<CategorySectionModel> = ArrayList()
                    for (p in data!!) {
                        if (p.categoryLabel.toUpperCase().startsWith(constraint.toString().toUpperCase())) list.add(p)
                    }
                    results.values = list
                    results.count = list.size
                }
                return results
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults) {
                // Now we have to inform the adapter about the new list filtered
                if (results.count == 0 || constraint == "") {
                    data = originalList
                    notifyDataSetChanged()
                } else {
                    data = results.values as ArrayList<CategorySectionModel>?
                    notifyDataSetChanged()
                }
            }
        }
    }


}
