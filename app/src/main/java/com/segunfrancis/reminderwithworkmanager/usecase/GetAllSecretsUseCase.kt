package com.segunfrancis.reminderwithworkmanager.usecase

import com.segunfrancis.reminderwithworkmanager.data.source.LocalSource
import com.segunfrancis.reminderwithworkmanager.domain.SecretItem
import com.segunfrancis.reminderwithworkmanager.presentation.util.SecretResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

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