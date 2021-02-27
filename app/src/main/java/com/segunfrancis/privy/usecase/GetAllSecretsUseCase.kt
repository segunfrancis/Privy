package com.segunfrancis.privy.usecase

import com.segunfrancis.privy.data.source.LocalSource
import com.segunfrancis.privy.domain.SecretItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetAllSecretsUseCase(
    private val source: LocalSource,
    private val dispatcher: CoroutineDispatcher
) {

   /* operator fun invoke(secretResult: (SecretResult<List<SecretItem>>) -> Unit) {
        CoroutineScope(dispatcher).launch {
            source.getAllSecrets().flowOn(dispatcher)
                .catch { secretResult(SecretResult.Error(it)) }
                .collect { secretResult(SecretResult.Success(it)) }
        }
    }*/

    operator fun invoke(): Flow<List<SecretItem>> {
        return source.getAllSecrets().flowOn(dispatcher)
    }
}