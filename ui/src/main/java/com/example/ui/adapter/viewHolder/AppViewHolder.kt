package com.example.ui.adapter.viewHolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.R
import com.example.ui.model.AppModel

class AppViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: AppModel) {

    }

    companion object {
        fun create(
            parent: ViewGroup
        ): AppViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.installed_app_item, parent, false
            )
            return AppViewHolder(view)
        }
    }

}