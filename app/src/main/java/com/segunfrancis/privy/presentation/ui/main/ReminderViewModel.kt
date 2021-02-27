package com.segunfrancis.privy.presentation.ui.main

import android.content.Context
import android.os.Build
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class ReminderViewModel(private val context: Context) {

    fun setReminder() {
        val constraints = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Constraints.Builder()
                .setRequiresCharging(false)
                .setRequiresDeviceIdle(false)
                .build()
        } else {
            Constraints.Builder()
                .setRequiresCharging(false)
                .build()
        }
        val reminderWork = OneTimeWorkRequestBuilder<ReminderWorker>()
            .setConstraints(constraints).build()
        WorkManager.getInstance(context).enqueue(reminderWork)
    }
}