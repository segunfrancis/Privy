package com.segunfrancis.reminderwithworkmanager.presentation.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseRecyclerAdapter<B : ViewDataBinding, T>(diffUtil: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, BaseViewHolder<T>>(diffUtil) {

    @get:LayoutRes
    protected abstract val layoutId: Int

    protected lateinit var binding: B

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return getViewHolder(view, this)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(getItem(position))
    }

    abstract fun getViewHolder(
        view: View,
        recyclerAdapter: BaseRecyclerAdapter<B, T>
    ): BaseViewHolder<T>
}