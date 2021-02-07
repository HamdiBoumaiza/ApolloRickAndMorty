package com.hb.rickandmortyapollo.datasource

import com.google.gson.Gson
import com.hb.rickandmortyapollo.GetCharactersQuery
import com.hb.rickandmortyapollo.data.commun.DataSourceException
import com.hb.rickandmortyapollo.data.commun.RickAndMortyResult
import com.hb.rickandmortyapollo.data.datasource.RemoteDataSource
import com.hb.rickandmortyapollo.helpers.getJson
import com.hb.rickandmortyapollo.utils.fromJsonToObjectType

class RemoteDataSourceImplTest : RemoteDataSource {

    override suspend fun getCharacters(page: Int): RickAndMortyResult<GetCharactersQuery.Characters?> {
        val result =
            Gson().fromJsonToObjectType<GetCharactersQuery.Data?>(getJson("list_characters.json"))
        return if (result != null) {
            RickAndMortyResult.Success(result.characters)
        } else {
            RickAndMortyResult.Error(DataSourceException.Server(emptyList()))
        }
    }

}