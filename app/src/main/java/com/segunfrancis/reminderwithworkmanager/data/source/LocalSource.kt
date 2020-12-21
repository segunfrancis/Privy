package com.segunfrancis.reminderwithworkmanager.data.source

import com.segunfrancis.reminderwithworkmanager.domain.SecretItem
import kotlinx.coroutines.flow.Flow

interface LocalSource {
    fun getAllSecrets(): Flow<List<SecretItem>>
    fun addSecret(secretItem: SecretItem): Flow<Unit>
    fun removeSecret(id: Long): Flow<Unit>
    fun removeAllSecrets(secretItem: SecretItem): Flow<Unit>
}