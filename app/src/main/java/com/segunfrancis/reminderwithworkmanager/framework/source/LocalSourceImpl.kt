package com.segunfrancis.reminderwithworkmanager.framework.source

import com.segunfrancis.reminderwithworkmanager.data.source.LocalSource
import com.segunfrancis.reminderwithworkmanager.domain.SecretItem
import com.segunfrancis.reminderwithworkmanager.framework.db.SecretDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalSourceImpl(private val database: SecretDatabase) : LocalSource {
    override fun getAllSecrets(): Flow<List<SecretItem>> {
        return database.dao().getAllSecrets()
    }

    override fun addSecret(secretItem: SecretItem): Flow<Unit> {
        return flow { emit(database.dao().addSecret(secretItem)) }
    }

    override fun removeSecret(id: Long): Flow<Unit> {
        return flow { emit(database.dao().removeSecret(id)) }
    }

    override fun removeAllSecrets(): Flow<Unit> {
        return flow { emit(database.dao().removeAllSecrets()) }
    }
}