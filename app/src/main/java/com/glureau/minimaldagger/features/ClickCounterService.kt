package com.glureau.minimaldagger.features

class ClickCounterService {

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