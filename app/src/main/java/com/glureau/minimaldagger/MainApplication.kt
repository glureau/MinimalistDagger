package com.glureau.minimaldagger

import android.app.Application
import com.glureau.minimaldagger.di.AppComponent
import com.glureau.minimaldagger.di.DaggerAppComponent

class MainApplication : Application() {
    val appComponent: AppComponent = DaggerAppComponent.create()
}