package com.example.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.adapter.viewHolder.AppViewHolder
import com.example.ui.model.AppModel

class AppAdapter : RecyclerView.Adapter<AppViewHolder>() {

    private val installedApps = mutableListOf<AppModel>()

    fun setData(list: List<AppModel>) {
        installedApps.clear()
        installedApps.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        return AppViewHolder.create(parent)
    }

    override fun getItemCount(): Int = installedApps.size

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        holder.bind(installedApps[position])
    }
}