package com.segunfrancis.reminderwithworkmanager.presentation.util

sealed class SecretResult<out T> {
    data class Success<T>(val data: T? = null): SecretResult<T>()
    data class Error(val error: Throwable): SecretResult<Nothing>()
}
