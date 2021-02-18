package com.hb.rickandmortyapollo.di

import com.hb.rickandmortyapollo.data.datasource.local.AppDao
import com.hb.rickandmortyapollo.data.datasource.remote.RemoteDataSourceImpl
import com.hb.rickandmortyapollo.data.repository.AppRepositoryImpl
import com.hb.rickandmortyapollo.domain.repository.AppRepository
import com.hb.rickandmortyapollo.domain.usecases.GetCharactersUseCase
import org.koin.dsl.module

val RepositoryModule = module {
    single { getCharactersUseCase(get()) }
    single { provideAppRepository(get()) }
}

fun provideAppRepository(appDao: AppDao): AppRepository {
    val remoteDataSourceImpl = RemoteDataSourceImpl()
    return AppRepositoryImpl(remoteDataSourceImpl, appDao)
}

fun getCharactersUseCase(appRepository: AppRepository): GetCharactersUseCase {
    return GetCharactersUseCase(appRepository)
}