package com.segunfrancis.reminderwithworkmanager.presentation.ui.main

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.segunfrancis.reminderwithworkmanager.R
import com.segunfrancis.reminderwithworkmanager.presentation.ui.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class ReminderWorker(private val appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    override fun doWork(): Result {
        runBlocking(Dispatchers.Main) {
            delay(10000)
            with(NotificationManagerCompat.from(appContext)) {
                notify(0, notificationBuilder(appContext).build())
            }
        }
        return Result.success()
    }

    init {
        createNotificationChannel(appContext)
    }

    private val intent = Intent(appContext, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    private val pendingIntent: PendingIntent = PendingIntent.getActivity(appContext, 0, intent, 0)

    private fun notificationBuilder(context: Context) = NotificationCompat.Builder(
        context,
        "channel_id"
    )
        .setSmallIcon(R.drawable.ic_notifications)
        .setContentTitle("Work is complete")
        .setContentText("The time has come for you to rise")
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)

    private fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channel_id", "reminder", importance)
                .apply { description = "The time has come" }
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
