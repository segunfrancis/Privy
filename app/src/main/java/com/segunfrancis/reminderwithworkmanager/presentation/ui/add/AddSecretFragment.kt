package com.segunfrancis.reminderwithworkmanager.presentation.ui.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.segunfrancis.reminderwithworkmanager.databinding.FragmentAddSecretBinding
import kotlinx.coroutines.flow.collect

class AddSecretFragment : Fragment() {

    private var _binding: FragmentAddSecretBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AddSecretViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddSecretBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.secretEditText.addTextChangedListener {
            viewModel.setSecretText(it.toString())
        }
        lifecycleScope.launchWhenStarted {
            viewModel.isSaveButtonEnabled().collect {
                binding.saveButton.isEnabled = it
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}