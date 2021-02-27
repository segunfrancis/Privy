package com.segunfrancis.privy.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

abstract class BaseFragment<B: ViewDataBinding, VM: ViewModel> : Fragment() {

    @get:LayoutRes
    protected abstract val layoutId: Int

    protected lateinit var binding: B

    protected abstract val viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    open fun launchFragment(destination: Int) {
        findNavController().navigate(destination)
    }

    open fun launchFragment(direction: NavDirections) {
        findNavController().navigate(direction)
    }
}