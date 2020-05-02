package com.glureau.minimaldagger.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.glureau.minimaldagger.R
import com.glureau.minimaldagger.features.ClickCounterService

class ClickableFragment : Fragment(R.layout.fragment_clickable) {
    // Injected by the Activity
    // BAD: nullable service because the activity is in charge of injecting it when the fragment is attached.
    // This means in some lifecycle states like onCreate the service will be null
    lateinit var clickCounterService: ClickCounterService

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // When the view is destroyed, the inner class (from this lambda) will be GCed.
        view.setOnClickListener { clickCounterService.incrementCounter() }
    }
}