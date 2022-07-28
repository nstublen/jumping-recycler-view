package com.example.jumpingrv

import android.view.View
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.RecyclerView

class ComposeViewHolder(composeView: View) : RecyclerView.ViewHolder(composeView) {
    private val composeView: ComposeView = itemView as ComposeView

    fun bind(viewState: ComposeViewState) {
        composeView.setContent {
            Text(viewState.text, modifier = Modifier.padding(16.dp))
        }
    }
}
