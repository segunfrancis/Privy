package com.segunfrancis.privy.presentation.ui.add

import androidx.lifecycle.ViewModel
import com.segunfrancis.privy.domain.SecretItem
import com.segunfrancis.privy.presentation.util.Navigation
import com.segunfrancis.privy.presentation.util.SecretResult
import com.segunfrancis.privy.usecase.AddSecretUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine

class AddSecretViewModel(
    private val addSecretUseCase: AddSecretUseCase
) : ViewModel() {

    var secretText = MutableStateFlow("")
    private var _secretTexts = MutableStateFlow("")

    private var _navigate: MutableStateFlow<Navigation> = MutableStateFlow(Navigation.DEFAULT)
    val navigate: StateFlow<Navigation> get() = _navigate

    fun setSecretText(text: String) {
        secretText.value = text
    }

    fun isSaveButtonEnabled(): Flow<Boolean> {
        return combine(secretText, _secretTexts) { a, b ->
            val isLongEnough = a.length > 10
            return@combine(isLongEnough)
        }
    }

    fun addSecret() {
        val secretItem = SecretItem(secretText.value, System.currentTimeMillis())
        addSecretUseCase(secretItem) { result ->
            when (result) {
                is SecretResult.Success -> {
                    _navigate.value = Navigation.SECRET_LIST
                }
                is SecretResult.Error -> {
                    _navigate.value = Navigation.ERROR
                }
            }
        }
    }
}