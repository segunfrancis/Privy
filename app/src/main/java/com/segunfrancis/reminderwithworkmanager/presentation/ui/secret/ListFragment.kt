package com.segunfrancis.reminderwithworkmanager.presentation.ui.secret

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.segunfrancis.reminderwithworkmanager.R
import com.segunfrancis.reminderwithworkmanager.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(layoutInflater)
        binding.buttonNavigateToAddFragment.setOnClickListener {
            navigateToAddFrag()
        }
        return binding.root
    }

    fun navigateToAddFrag() {
        findNavController().navigate(R.id.addSecretFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}