package com.segunfrancis.reminderwithworkmanager.presentation.ui

import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.segunfrancis.reminderwithworkmanager.R
import com.segunfrancis.reminderwithworkmanager.databinding.ActivityMainBinding
import com.segunfrancis.reminderwithworkmanager.presentation.ui.base.BaseActivity
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val resId: Int get() = R.layout.activity_main
    override val viewModel: MainViewModel by viewModel()

    private val navController: NavController
            by lazy { findNavController(R.id.nav_host_fragment) }

    private var job: Job? = null

    override fun onStart() {
        super.onStart()
        setupActionBarWithNavController(navController)
        job = lifecycleScope.launch {
            viewModel.newDestination.observe(this@MainActivity) { destination ->
                navigate(destination)
                Toast.makeText(this@MainActivity, "$destination", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigate(destinationId: Int) {
        navController.navigate(destinationId)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onStop() {
        super.onStop()
        job?.cancel()
        job = null
    }
}