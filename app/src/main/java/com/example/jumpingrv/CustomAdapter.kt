package com.example.jumpingrv

import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class CustomAdapter : ListAdapter<ComposeViewState, ComposeViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComposeViewHolder {
        return ComposeViewHolder(ComposeView(parent.context))
    }

    override fun onBindViewHolder(holder: ComposeViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<ComposeViewState>() {
            override fun areItemsTheSame(
                oldItem: ComposeViewState,
                newItem: ComposeViewState
            ): Boolean {
                return oldItem.identifier == newItem.identifier
            }

            override fun areContentsTheSame(
                oldItem: ComposeViewState,
                newItem: ComposeViewState
            ): Boolean {
                return oldItem.text == newItem.text
            }
        }
    }
}