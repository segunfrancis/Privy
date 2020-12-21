package com.segunfrancis.reminderwithworkmanager.presentation.ui.secret

import androidx.lifecycle.ViewModel
import com.segunfrancis.reminderwithworkmanager.domain.SecretItem
import com.segunfrancis.reminderwithworkmanager.presentation.util.SecretResult
import com.segunfrancis.reminderwithworkmanager.usecase.GetAllSecretsUseCase
import com.segunfrancis.reminderwithworkmanager.usecase.RemoveSecretUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf

class SecretListViewModel(
    private val getAllSecretsUseCase: GetAllSecretsUseCase,
    private val removeSecretUseCase: RemoveSecretUseCase,
    private val removeAllSecretsUseCase: GetAllSecretsUseCase
) : ViewModel() {

    fun removeSecret(id: Long) {
        removeSecretUseCase(id) { result ->
            when (result) {
                is SecretResult.Success -> {
                }
                is SecretResult.Error -> {
                }
            }
        }
    }

    fun removeAllSecrets() {
        removeAllSecretsUseCase { result ->
            when (result) {
                is SecretResult.Success -> {
                }
                is SecretResult.Error -> {
                }
            }
        }
    }

    fun getAllSecrets() {
        getAllSecretsUseCase { result ->
            when (result) {
                is SecretResult.Success -> {
                }
                is SecretResult.Error -> {
                }
            }
        }
    }
}