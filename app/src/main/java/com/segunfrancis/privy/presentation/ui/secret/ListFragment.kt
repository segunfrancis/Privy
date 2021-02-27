package com.segunfrancis.privy.presentation.ui.secret

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.segunfrancis.privy.R
import com.segunfrancis.privy.databinding.FragmentListBinding
import com.segunfrancis.privy.presentation.ui.MainViewModel
import com.segunfrancis.privy.presentation.ui.base.BaseFragment
import com.segunfrancis.privy.presentation.util.Navigation
import com.segunfrancis.privy.presentation.util.showMessage
import kotlinx.coroutines.flow.collect
import org.koin.android.viewmodel.ext.android.viewModel

class ListFragment : BaseFragment<FragmentListBinding, SecretListViewModel>() {

    override val layoutId: Int get() = R.layout.fragment_list
    override val viewModel: SecretListViewModel by viewModel()

    private val navViewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val secretAdapter = SecretAdapter()
        binding.apply {
            buttonNavigateToAddFragment.setOnClickListener {
                launchFragment(ListFragmentDirections.actionListFragmentToAddSecretFragment())
            }
            secretRecyclerView.layoutManager = StaggeredGridLayoutManager(2, VERTICAL)
            secretRecyclerView.adapter = secretAdapter
        }
        binding.viewModel = viewModel
        binding.navViewModel = navViewModel
        //binding.navDirection = ListFragmentDirections.actionListFragmentToAddSecretFragment()
        lifecycleScope.launchWhenStarted {
            viewModel.navigate.collect { navigation ->
                when (navigation) {
                    Navigation.SECRET_LIST -> {
                        launchFragment(R.id.listFragment)
                    }
                    Navigation.DEFAULT -> {
                    }
                    Navigation.ADD_SECRET -> {
                        launchFragment(R.id.addSecretFragment)
                    }
                    Navigation.ERROR -> {
                        requireView().showMessage("Something went wrong")
                    }
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.getAllSecrets().collect {
                secretAdapter.submitList(it)
            }
        }
    }
}