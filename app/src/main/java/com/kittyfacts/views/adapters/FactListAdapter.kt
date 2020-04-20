package com.kittyfacts.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kittyfacts.R
import com.kittyfacts.models.Fact

class FactListAdapter(private val list: List<Fact>) :
    RecyclerView.Adapter<FactListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup?.context).inflate(R.layout.row_kitty_fact_list, viewGroup, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.name?.text = list[position].text
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tv_fact_list_title)
    }

}