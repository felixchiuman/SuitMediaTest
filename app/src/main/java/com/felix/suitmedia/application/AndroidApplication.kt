package com.felix.suitmedia.application

import android.app.Application
import android.content.Context
import com.felix.suitmedia.di.networkModule
import com.felix.suitmedia.di.repositoryModule
import com.felix.suitmedia.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AndroidApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AndroidApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}