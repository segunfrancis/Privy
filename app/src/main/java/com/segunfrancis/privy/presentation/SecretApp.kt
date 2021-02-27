package com.segunfrancis.privy.presentation

import android.app.Application
import com.segunfrancis.privy.presentation.di.useCaseModule
import com.segunfrancis.privy.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SecretApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@SecretApp)
            modules(useCaseModule, viewModelModule)
        }
    }
}