package com.segunfrancis.privy.data.source

import com.segunfrancis.privy.domain.SecretItem
import kotlinx.coroutines.flow.Flow

interface LocalSource {
    fun getAllSecrets(): Flow<List<SecretItem>>
    fun addSecret(secretItem: SecretItem): Flow<Unit>
    fun removeSecret(id: Long): Flow<Unit>
    fun removeAllSecrets(): Flow<Unit>
}