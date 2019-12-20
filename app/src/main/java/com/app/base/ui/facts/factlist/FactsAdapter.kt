package com.app.base.ui.facts.factlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.app.base.R
import com.app.base.room.entity.FactData
import kotlinx.android.synthetic.main.item_facts.view.*

class FactsAdapter(val data: List<FactData>, private val clickListener: FactsActivity) : RecyclerView.Adapter<FactsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_facts, parent, false) as CardView
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.iv_save_fact.setOnClickListener {
            if (this.data[position].saveStatus) {
                clickListener.invoke(this.data[position].id, false)
                holder.itemView.iv_save_fact.setBackgroundResource(R.drawable.ic_unlike)
            } else {
                clickListener.invoke(this.data[position].id, true)
                holder.itemView.iv_save_fact.setBackgroundResource(R.drawable.ic_like)
            }
        }
        holder.bindItems(this.data[position], position)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindItems(data: FactData, pos: Int) {
            itemView.tv_facts.text = data.fact
            itemView.tv_fact_count.text = "#$pos"
            if (data.saveStatus) {
                itemView.iv_save_fact.setBackgroundResource(R.drawable.ic_like)
            } else {
                itemView.iv_save_fact.setBackgroundResource(R.drawable.ic_unlike)
            }

        }
    }


}