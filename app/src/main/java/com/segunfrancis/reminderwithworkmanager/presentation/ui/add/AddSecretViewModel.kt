package com.segunfrancis.reminderwithworkmanager.presentation.ui.add

import androidx.lifecycle.ViewModel
import com.segunfrancis.reminderwithworkmanager.domain.SecretItem
import com.segunfrancis.reminderwithworkmanager.presentation.util.SecretResult
import com.segunfrancis.reminderwithworkmanager.usecase.AddSecretUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine

class AddSecretViewModel(
    private val addSecretUseCase: AddSecretUseCase
) : ViewModel() {

    private var _secretText = MutableStateFlow("")
    private var _secretTexts = MutableStateFlow("")

    fun setSecretText(text: String) {
        _secretText.value = text
    }

    fun isSaveButtonEnabled(): Flow<Boolean> {
        return combine(_secretText, _secretTexts) { a, b ->
            val isLongEnough = a.length > 10
            return@combine(isLongEnough)
        }
    }

    fun addSecret(secretItem: SecretItem) {
        addSecretUseCase(secretItem) { result ->
            when (result) {
                is SecretResult.Success -> {
                }
                is SecretResult.Error -> {
                }
            }
        }
    }


}