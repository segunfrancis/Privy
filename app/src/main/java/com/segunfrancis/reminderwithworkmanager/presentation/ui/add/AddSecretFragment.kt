package com.segunfrancis.reminderwithworkmanager.presentation.ui.add

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.segunfrancis.reminderwithworkmanager.R
import com.segunfrancis.reminderwithworkmanager.databinding.FragmentAddSecretBinding
import com.segunfrancis.reminderwithworkmanager.presentation.ui.base.BaseFragment
import com.segunfrancis.reminderwithworkmanager.presentation.util.Navigation
import com.segunfrancis.reminderwithworkmanager.presentation.util.showMessage
import kotlinx.coroutines.flow.collect
import org.koin.android.viewmodel.ext.android.viewModel

class AddSecretFragment : BaseFragment<FragmentAddSecretBinding, AddSecretViewModel>() {

    override val viewModel: AddSecretViewModel by viewModel()

    override val layoutId: Int
        get() = R.layout.fragment_add_secret

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel

        binding.secretEditText.addTextChangedListener {
            viewModel.setSecretText(it.toString())
        }
        lifecycleScope.launchWhenStarted {
            viewModel.isSaveButtonEnabled().collect {
                binding.saveButton.isEnabled = it
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.navigate.collect { navigation ->
                when (navigation) {
                    Navigation.SECRET_LIST -> {
                        launchFragment(R.id.listFragment)
                    }
                    Navigation.DEFAULT -> {
                    }
                    Navigation.ADD_SECRET -> {
                    }
                    Navigation.ERROR -> {
                        requireView().showMessage("Something went wrong")
                    }
                }
            }
        }
    }
}