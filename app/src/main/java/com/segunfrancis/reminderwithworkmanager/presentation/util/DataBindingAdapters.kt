package com.segunfrancis.reminderwithworkmanager.presentation.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.segunfrancis.reminderwithworkmanager.domain.SecretItem

@BindingAdapter("populate")
fun displayList(recyclerView: RecyclerView, secrets: List<SecretItem>) {
    recyclerView.apply {
        layoutManager = LinearLayoutManager(recyclerView.context)
    }
}