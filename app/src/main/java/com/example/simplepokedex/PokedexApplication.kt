package com.example.simplepokedex

import android.app.Application
import com.example.library.networking.di.networkingModule
import com.example.library.persistent.di.persistentModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class PokedexApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokedexApplication)
            modules(
                persistentModule,
                networkingModule,
            )
        }
    }
}