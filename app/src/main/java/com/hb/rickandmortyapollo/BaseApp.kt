package com.hb.rickandmortyapollo

import android.app.Application
import com.hb.rickandmortyapollo.di.RepositoryModule
import com.hb.rickandmortyapollo.di.StorageModule
import com.hb.rickandmortyapollo.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BaseApp)
            modules(listOf(RepositoryModule, StorageModule, ViewModelModule))
        }
    }
}