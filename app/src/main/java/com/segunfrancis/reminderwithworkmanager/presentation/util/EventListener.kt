package com.segunfrancis.reminderwithworkmanager.presentation.util

interface EventListener<T> {
    fun onEvent(t: T)
}