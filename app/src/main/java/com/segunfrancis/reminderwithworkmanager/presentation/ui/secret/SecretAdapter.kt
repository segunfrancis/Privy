package com.segunfrancis.reminderwithworkmanager.presentation.ui.secret

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import com.segunfrancis.reminderwithworkmanager.R
import com.segunfrancis.reminderwithworkmanager.databinding.ItemSecretBinding
import com.segunfrancis.reminderwithworkmanager.domain.SecretItem
import com.segunfrancis.reminderwithworkmanager.presentation.ui.base.BaseRecyclerAdapter
import com.segunfrancis.reminderwithworkmanager.presentation.ui.base.BaseViewHolder
import com.segunfrancis.reminderwithworkmanager.presentation.util.formatTime

class SecretAdapter : BaseRecyclerAdapter<ItemSecretBinding, SecretItem>(SecretDiffUtil()) {
    override val layoutId: Int
        get() = R.layout.item_secret

    override fun getViewHolder(
        view: View,
        recyclerAdapter: BaseRecyclerAdapter<ItemSecretBinding, SecretItem>
    ): BaseViewHolder<SecretItem> {
        return SecretViewHolder(ItemSecretBinding.bind(view))
    }
}

class SecretViewHolder(private val binding: ItemSecretBinding) :
    BaseViewHolder<SecretItem>(binding.root) {
    override fun bind(item: SecretItem) = with(binding) {
        textSecret.text = item.secret
        textDate.text = item.id.formatTime()
    }
}

class SecretDiffUtil : DiffUtil.ItemCallback<SecretItem>() {
    override fun areItemsTheSame(oldItem: SecretItem, newItem: SecretItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SecretItem, newItem: SecretItem): Boolean {
        return oldItem == newItem
    }
}
