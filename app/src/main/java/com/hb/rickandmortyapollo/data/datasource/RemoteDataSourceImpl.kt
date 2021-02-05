package com.hb.rickandmortyapollo.data.datasource

import android.util.Log
import com.apollographql.apollo.coroutines.await
import com.hb.rickandmortyapollo.GetCharactersQuery
import com.hb.rickandmortyapollo.data.commun.DataSourceException
import com.hb.rickandmortyapollo.data.GraphQlApolloClient
import com.hb.rickandmortyapollo.data.commun.RickAndMortyResult

class RemoteDataSourceImpl : RemoteDataSource {

    override suspend fun getCharacters(page: Int): RickAndMortyResult<GetCharactersQuery.Characters?> {
        return try {
            val result = GraphQlApolloClient.getCharacters(page).await()
            if (result.hasErrors()) {
                RickAndMortyResult.Error(DataSourceException.Client(result.errors))
            } else {
                RickAndMortyResult.Success(result.data?.characters)
            }
        } catch (e: Exception) {
            Log.e("ee",e.toString())
            RickAndMortyResult.Error(DataSourceException.Unexpected("result error"))
        }
    }

}