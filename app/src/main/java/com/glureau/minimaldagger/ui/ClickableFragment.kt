package com.glureau.minimaldagger.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.glureau.minimaldagger.R
import com.glureau.minimaldagger.di.injector
import com.glureau.minimaldagger.features.ClickCounterService
import javax.inject.Inject

class ClickableFragment : Fragment(R.layout.fragment_clickable) {

    @Inject
    lateinit var clickCounterService: ClickCounterService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // When the view is destroyed, the inner class (from this lambda) will be GCed.
        view.setOnClickListener { clickCounterService.incrementCounter() }
    }
}