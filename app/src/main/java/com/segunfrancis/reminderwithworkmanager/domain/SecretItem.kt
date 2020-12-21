package com.segunfrancis.reminderwithworkmanager.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "secret_table")
data class SecretItem(val secret: String, @PrimaryKey val id: Long)