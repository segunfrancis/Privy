package com.segunfrancis.privy.usecase

import com.segunfrancis.privy.data.source.LocalSource
import com.segunfrancis.privy.domain.SecretItem
import com.segunfrancis.privy.presentation.util.SecretResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class RemoveSecretUseCase(
    private val localSource: LocalSource,
    private val dispatcher: CoroutineDispatcher
) {

    operator fun invoke(id: Long, result: (SecretResult<SecretItem>) -> Unit) {
        CoroutineScope(dispatcher).launch {
            localSource.removeSecret(id).flowOn(dispatcher)
                .catch { result(SecretResult.Error(it)) }
                .collect { result(SecretResult.Success()) }
        }
    }
}