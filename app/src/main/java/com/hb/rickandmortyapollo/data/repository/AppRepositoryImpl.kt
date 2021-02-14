package com.hb.rickandmortyapollo.data.repository


import com.hb.rickandmortyapollo.data.commun.RickAndMortyResult
import com.hb.rickandmortyapollo.data.datasource.local.AppDao
import com.hb.rickandmortyapollo.data.datasource.remote.RemoteDataSource
import com.hb.rickandmortyapollo.data.mappers.mapToDomainModel
import com.hb.rickandmortyapollo.domain.models.CharactersModel
import com.hb.rickandmortyapollo.domain.models.InfoModel
import com.hb.rickandmortyapollo.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

class AppRepositoryImpl(
    private val remoteDataSource: RemoteDataSource, private val appDao: AppDao,
) :
    AppRepository {
    override suspend fun getCharacters(page: Int): Flow<RickAndMortyResult<CharactersModel>> =
        flow {
            when (val result = remoteDataSource.getCharacters(page)) {
                is RickAndMortyResult.Success -> {
                    result.data?.let {
                        it.mapToDomainModel().apply {
                            appDao.saveListCharacters(results)
                            emit(RickAndMortyResult.Success(this))
                        }
                    }
                }
                is RickAndMortyResult.Error -> {
                    if (appDao.getListCharacters().isNotEmpty()) {
                        emit(
                            RickAndMortyResult.Success(
                                CharactersModel(
                                    InfoModel(),
                                    appDao.getListCharacters()
                                )
                            )
                        )
                    } else {
                        emit(RickAndMortyResult.Error(result.exception))
                    }
                }
            }
        }.onStart { emit(RickAndMortyResult.Loading) }
}
