package com.glureau.minimaldagger.di

import androidx.fragment.app.Fragment
import com.glureau.minimaldagger.MainApplication
import com.glureau.minimaldagger.ui.ClickableFragment
import com.glureau.minimaldagger.ui.CounterFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {
    fun inject(f: ClickableFragment)
    fun inject(f: CounterFragment)
}

val Fragment.injector: AppComponent
    get() = (requireActivity().application as MainApplication).appComponent