package com.hb.rickandmortyapollo.di

import com.hb.rickandmortyapollo.data.datasource.local.AppDao
import com.hb.rickandmortyapollo.data.datasource.remote.RemoteDataSourceImpl
import com.hb.rickandmortyapollo.data.repository.AppRepositoryImpl
import com.hb.rickandmortyapollo.domain.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAppRepository(appDao: AppDao): AppRepository {
        val remoteDataSourceImpl = RemoteDataSourceImpl()
        return AppRepositoryImpl(remoteDataSourceImpl, appDao)
    }
}