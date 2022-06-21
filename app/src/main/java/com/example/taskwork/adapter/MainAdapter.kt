package com.example.taskwork.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.taskwork.databinding.ItemBinding
import com.example.taskwork.model.Item

/*
To the superclass PagingDataAdapter, we pass in the Item data class as that is the type of data we want to show
in the RecyclerView and MainViewHolder as the type of view holder we want to use.
 */

class MainAdapter : PagingDataAdapter<Item, MainAdapter.MainViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem == newItem
        }
    }

    inner class MainViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)

    /*
    We instantiate and bind data to the view holder in the onCreateViewHolder()
    and onBindViewHolder() functions respectively.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = getItem(position)

        holder.binding.apply {
            textView.text = item?.name
        }
    }
}