package com.example.ui.adapter.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.R
import com.example.ui.databinding.InstalledAppItemBinding
import com.example.ui.model.AppModel
import com.example.ui.util.loadUrl

class AppViewHolder(private val binding: InstalledAppItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: AppModel) {
        binding.appName.text = item.appName
        binding.appImage.loadUrl(item.appIcon)
    }

    companion object {
        fun create(
            parent: ViewGroup
        ): AppViewHolder {
            val binding =
                InstalledAppItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return AppViewHolder(binding)
        }
    }

}