package com.segunfrancis.reminderwithworkmanager.framework.db

import androidx.room.*
import com.segunfrancis.reminderwithworkmanager.domain.SecretItem
import kotlinx.coroutines.flow.Flow

@Dao
interface SecretDao {
    @Query("SELECT * FROM secret_table")
    fun getAllSecrets(): Flow<List<SecretItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSecret(secretItem: SecretItem)

    @Query("DELETE FROM secret_table WHERE :id is id")
    suspend fun removeSecret(id: Long)

    @Delete
    suspend fun removeAllSecrets(secretItem: SecretItem)
}