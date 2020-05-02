package com.glureau.minimaldagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.glureau.minimaldagger.features.ClickCounterService
import com.glureau.minimaldagger.ui.ClickableFragment
import com.glureau.minimaldagger.ui.CounterFragment

class MainActivity : AppCompatActivity() {

    // BAD: Activity knows about a service used by its fragment, should not be the case.
    // BAD: Activity should not be responsible to create domain components
    private val clickCounterService = ClickCounterService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onAttachFragment(fragment: Fragment) {
        // BAD: Activity has to describe all Fragment subclasses.
        // Forgot a fragment class = runtime crash
        if (fragment is ClickableFragment) {
            fragment.clickCounterService = clickCounterService
        }
        if (fragment is CounterFragment) {
            fragment.clickCounterService = clickCounterService
        }
    }
}
