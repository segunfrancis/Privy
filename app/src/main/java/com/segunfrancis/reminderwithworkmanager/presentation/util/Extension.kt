package com.segunfrancis.reminderwithworkmanager.presentation.util

import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.segunfrancis.reminderwithworkmanager.R
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*

fun String.hash(): ByteArray {
    val messageDigest = MessageDigest.getInstance("SHA-256")
    return messageDigest.digest(this.toByteArray(StandardCharsets.UTF_8))
}

fun View.showMessage(message: String) {
    val snack = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    snack.setBackgroundTint(ContextCompat.getColor(this.context, R.color.error_red))
    snack.show()
}

fun Long.formatTime(): String {
    val date = Date(this)
    val formatter = SimpleDateFormat("h:mm a", Locale.getDefault())
    return formatter.format(date)
}