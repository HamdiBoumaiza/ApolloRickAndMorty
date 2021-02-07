package com.hb.rickandmortyapollo.repository

import com.hb.rickandmortyapollo.data.commun.RickAndMortyResult
import com.hb.rickandmortyapollo.data.mappers.mapToDomainModel
import com.hb.rickandmortyapollo.datasource.RemoteDataSourceImplTest
import com.hb.rickandmortyapollo.domain.models.CharactersModel
import com.hb.rickandmortyapollo.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AppRepositoryImplTest(private val dataSourceImplTest: RemoteDataSourceImplTest) :
    AppRepository {

    override suspend fun getCharacters(page: Int): Flow<RickAndMortyResult<CharactersModel>> {
        return flow {
            dataSourceImplTest.getCharacters(page).run {
                when (this) {
                    is RickAndMortyResult.Success -> {
                        data?.let {
                            emit(RickAndMortyResult.Success(it.mapToDomainModel()))
                        }
                    }
                    is RickAndMortyResult.Error -> {
                        emit(RickAndMortyResult.Error(exception))
                    }
                }
            }
        }
    }

}