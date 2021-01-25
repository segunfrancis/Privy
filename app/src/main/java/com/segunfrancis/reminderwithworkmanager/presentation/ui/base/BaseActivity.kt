package com.segunfrancis.reminderwithworkmanager.presentation.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<B: ViewDataBinding, VM: ViewModel> : AppCompatActivity() {

    @get:LayoutRes
    protected abstract val resId: Int

    protected lateinit var binding: B

    protected abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, resId)
        binding.lifecycleOwner = this
    }
}