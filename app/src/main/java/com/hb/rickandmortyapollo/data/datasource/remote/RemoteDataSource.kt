package com.hb.rickandmortyapollo.data.datasource.remote

import com.hb.rickandmortyapollo.GetCharactersQuery
import com.hb.rickandmortyapollo.data.commun.RickAndMortyResult


interface RemoteDataSource {
    suspend fun getCharacters(page :Int): RickAndMortyResult<GetCharactersQuery.Characters?>
}