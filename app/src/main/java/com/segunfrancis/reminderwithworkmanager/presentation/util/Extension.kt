package com.segunfrancis.reminderwithworkmanager.presentation.util

import java.nio.charset.StandardCharsets
import java.security.MessageDigest

fun String.hash(): ByteArray {
    val messageDigest = MessageDigest.getInstance("SHA-256")
    return messageDigest.digest(this.toByteArray(StandardCharsets.UTF_8))
}