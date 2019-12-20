package com.app.base.ui.facts.favourite

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.app.base.R
import com.app.base.room.entity.FactData
import kotlinx.android.synthetic.main.item_fav.view.*

class FavouriteAdapter(val data: MutableList<FactData>?, private val clickListener: FavouriteActivity) : RecyclerView.Adapter<FavouriteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_fav, parent, false) as CardView
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(this.data?.get(position)!!.fact, position)
    }

    fun removeItem(position: Int) {
        data!!.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, data.size)
    }

    fun restoreItem(model: FactData, position: Int) {
        data!!.add(position, model)
        // notify item added by position
        notifyItemInserted(position)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindItems(fact: String, pos: Int) {
            itemView.tv_fav.text = fact
        }
    }


}