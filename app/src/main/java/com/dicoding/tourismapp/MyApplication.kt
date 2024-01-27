package com.dicoding.tourismapp

import android.app.Application
import com.dicoding.tourismapp.core.data.di.*
import com.dicoding.tourismapp.core.di.*
import org.koin.android.ext.koin.*
import org.koin.core.context.*
import org.koin.core.logger.*

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}