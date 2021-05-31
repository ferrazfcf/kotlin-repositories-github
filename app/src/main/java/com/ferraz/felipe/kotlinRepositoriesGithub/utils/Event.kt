package com.ferraz.felipe.kotlinRepositoriesGithub.utils

/**
 * Event wrapper to expose data via LiveData as an event
 */
class Event<out EventType>(private val content: EventType) {

    var isHandled = false
        private set

    fun getContentIfNotHandled(): EventType? {
        if (isHandled) return null

        isHandled = true
        return content
    }

    fun getContent() = content
}
