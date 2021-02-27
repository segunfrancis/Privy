package com.segunfrancis.privy.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _newDestination: MutableLiveData<Int> = MutableLiveData()
    val newDestination: LiveData<Int>
        get() = _newDestination


    fun setNewDestination(destinationId: Int) {
        _newDestination.value = destinationId
    }
}