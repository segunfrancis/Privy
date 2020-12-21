package com.segunfrancis.reminderwithworkmanager.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.segunfrancis.reminderwithworkmanager.domain.SecretItem

@Database(exportSchema = false, version = 1, entities = [SecretItem::class])
abstract class SecretDatabase : RoomDatabase() {
    abstract fun dao(): SecretDao
}