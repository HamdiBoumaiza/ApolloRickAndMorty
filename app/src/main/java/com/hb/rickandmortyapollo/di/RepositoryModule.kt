package com.hb.rickandmortyapollo.di

import com.hb.rickandmortyapollo.data.datasource.RemoteDataSourceImpl
import com.hb.rickandmortyapollo.data.repository.AppRepositoryImpl
import com.hb.rickandmortyapollo.domain.repository.AppRepository
import com.hb.rickandmortyapollo.domain.usecases.GetCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAppRepository(): AppRepository {
        val starWarsDataSourceImpl = RemoteDataSourceImpl()
        return AppRepositoryImpl(starWarsDataSourceImpl)
    }

    @Provides
    fun provideGetCharactersUseCase(
        appRepository: AppRepository
    ): GetCharactersUseCase =
        GetCharactersUseCase(appRepository)

}