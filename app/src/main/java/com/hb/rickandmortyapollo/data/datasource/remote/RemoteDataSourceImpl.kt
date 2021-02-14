package com.hb.rickandmortyapollo.data.datasource.remote

import com.apollographql.apollo.coroutines.await
import com.hb.rickandmortyapollo.GetCharactersQuery
import com.hb.rickandmortyapollo.R
import com.hb.rickandmortyapollo.data.GraphQlApolloClient
import com.hb.rickandmortyapollo.data.commun.DataSourceException
import com.hb.rickandmortyapollo.data.commun.RickAndMortyResult

class RemoteDataSourceImpl : RemoteDataSource {

    override suspend fun getCharacters(page: Int): RickAndMortyResult<GetCharactersQuery.Characters?> {
        return try {
            val result = GraphQlApolloClient.getCharacters(page).await()
            if (result.hasErrors()) {
                RickAndMortyResult.Error(DataSourceException.Server(result.errors?.first()))
            } else {
                RickAndMortyResult.Success(result.data?.characters)
            }
        } catch (e: Exception) {
            RickAndMortyResult.Error(DataSourceException.Unexpected(R.string.error_unexpected_message))
        }
    }

}