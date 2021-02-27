package com.segunfrancis.privy.presentation.ui.secret

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.segunfrancis.privy.domain.SecretItem
import com.segunfrancis.privy.presentation.util.Navigation
import com.segunfrancis.privy.presentation.util.SecretResult
import com.segunfrancis.privy.usecase.GetAllSecretsUseCase
import com.segunfrancis.privy.usecase.RemoveAllSecretsUseCase
import com.segunfrancis.privy.usecase.RemoveSecretUseCase
import kotlinx.coroutines.flow.*

class SecretListViewModel(
    private val getAllSecretsUseCase: GetAllSecretsUseCase,
    private val removeSecretUseCase: RemoveSecretUseCase,
    private val removeAllSecretsUseCase: RemoveAllSecretsUseCase
) : ViewModel() {

    private val initialValue: List<SecretItem> = emptyList()

    private var _navigate: MutableStateFlow<Navigation> = MutableStateFlow(Navigation.DEFAULT)
    val navigate: StateFlow<Navigation> get() = _navigate

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

    fun getAllSecrets(): StateFlow<List<SecretItem>> {
        return getAllSecretsUseCase().catch { }
            .stateIn(viewModelScope, SharingStarted.Lazily, initialValue)
    }

    fun navigate(navigation: Navigation) {
        _navigate.value = navigation
        _navigate.value = Navigation.DEFAULT
    }
}