package com.glureau.minimaldagger.features

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClickCounterService @Inject constructor() {

    private var clickCounter = 0

    fun incrementCounter() {
        clickCounter++
        // Propagate the change
        listeners.forEach {
            it.onClickCountChanged(clickCounter)
        }
    }

    // Pattern observable, can be replaced by any async lib (RxJava, LiveData, ...)
    interface ClickCountListener {
        fun onClickCountChanged(clickCount: Int)
    }

    private val listeners = mutableListOf<ClickCountListener>()
    fun addListener(listener: ClickCountListener) = listeners.add(listener)
    fun removeListener(listener: ClickCountListener) = listeners.remove(listener)
}