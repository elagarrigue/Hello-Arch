package com.android.ejercicios.helloarch

import android.app.Application
import org.koin.android.ext.android.startKoin

class MyApp : Application(){
  override fun onCreate() {
    super.onCreate()
    // Start Koin
    startKoin(this, listOf(appModule))
  }
}