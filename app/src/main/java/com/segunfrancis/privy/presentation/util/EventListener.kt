package com.segunfrancis.privy.presentation.util

interface EventListener<T> {
    fun onEvent(t: T)
}