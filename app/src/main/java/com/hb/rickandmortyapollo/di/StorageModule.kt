package com.hb.rickandmortyapollo.di

import android.content.Context
import com.hb.rickandmortyapollo.data.datasource.local.AppDb
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val StorageModule = module {
    single { provideAppDatabase(androidContext()) }
    single { provideAppDAO(get()) }
}

fun provideAppDatabase(context: Context) = AppDb.getDatabase(context)

fun provideAppDAO(db: AppDb) = db.appDao()