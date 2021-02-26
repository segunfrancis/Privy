package com.segunfrancis.reminderwithworkmanager.presentation.util

import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.segunfrancis.reminderwithworkmanager.R
import java.security.SecureRandom
import java.text.SimpleDateFormat
import java.util.*
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec
import kotlin.collections.HashMap

fun encrypt(dataToEncrypt: ByteArray, password: CharArray): HashMap<String, ByteArray> {
    val map = hashMapOf<String, ByteArray>()
    try {
        val random = SecureRandom()
        val salt = ByteArray(256)
        random.nextBytes(salt)
        val pbKeySPec = PBEKeySpec(password, salt, 1324, 256)
        val secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
        val keyBytes = secretKeyFactory.generateSecret(pbKeySPec).encoded
        val keySpec = SecretKeySpec(keyBytes, "AES")
        val ivRandom = SecureRandom()
        val iv = ByteArray(16)
        ivRandom.nextBytes(iv)
        val ivSpec = IvParameterSpec(iv)
        val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec)
        val encrypted = cipher.doFinal(dataToEncrypt)
        map["salt"] = salt
        map["iv"] = iv
        map["encrypted"] = encrypted
    } catch (e: Exception) {
        Log.e("SecretException", "encrypt: ${e.localizedMessage}")
    }
    return map
}

fun decrypt(map: HashMap<String, ByteArray>, password: CharArray): ByteArray? {
    var decrypted: ByteArray? = null
    try {
        // 1
        val salt = map["salt"]
        val iv = map["iv"]
        val encrypted = map["encrypted"]

        // 2
        //regenerate key from password
        val pbKeySpec = PBEKeySpec(password, salt, 1324, 256)
        val secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
        val keyBytes = secretKeyFactory.generateSecret(pbKeySpec).encoded
        val keySpec = SecretKeySpec(keyBytes, "AES")

        // 3
        //Decrypt
        val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")
        val ivSpec = IvParameterSpec(iv)
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec)
        decrypted = cipher.doFinal(encrypted)
    } catch (e: Exception) {
        Log.e("SecretException", "decrypt: ${e.localizedMessage}")
    }
    return decrypted
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