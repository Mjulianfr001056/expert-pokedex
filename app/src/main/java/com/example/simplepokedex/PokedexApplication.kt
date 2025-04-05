package com.example.simplepokedex

import android.app.Application
import com.example.simplepokedex.di.repositoryModule
import com.example.simplepokedex.di.useCaseModule
import com.example.simplepokedex.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class PokedexApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokedexApplication)
            modules(
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}