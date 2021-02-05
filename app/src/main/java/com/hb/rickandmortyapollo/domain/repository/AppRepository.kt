package com.hb.rickandmortyapollo.domain.repository

import com.hb.rickandmortyapollo.data.commun.RickAndMortyResult
import com.hb.rickandmortyapollo.domain.models.CharactersModel
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    suspend fun getCharacters(page: Int): Flow<RickAndMortyResult<CharactersModel>>
}