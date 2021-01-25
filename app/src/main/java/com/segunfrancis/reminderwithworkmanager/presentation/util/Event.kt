package com.segunfrancis.reminderwithworkmanager.presentation.util

import androidx.annotation.Nullable


class Event<T>(private val content: T) {
    private var consumed = false
    @Nullable
    fun consume(): T? {
        if (consumed) return null
        consumed = true
        return content
    }

    fun peek(): T {
        return content
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other!!.javaClass) return false
        val others = other as Event<*>?
        return if (content !== others!!.content) false else consumed === others!!.consumed
    }

    override fun hashCode(): Int {
        var hash = content.hashCode()
        hash *= 31 * consumed.hashCode()
        return hash
    }
}