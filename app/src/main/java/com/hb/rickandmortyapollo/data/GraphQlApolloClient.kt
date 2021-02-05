package com.hb.rickandmortyapollo.data

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.ApolloQueryCall
import com.apollographql.apollo.api.Input
import com.hb.rickandmortyapollo.GetCharactersQuery
import com.hb.rickandmortyapollo.data.commun.BASE_URL

object GraphQlApolloClient {

    private fun apolloClient(): ApolloClient =
        ApolloClient.builder().serverUrl(BASE_URL).build()


    fun getCharacters(page: Int): ApolloQueryCall<GetCharactersQuery.Data> =
        apolloClient().query(GetCharactersQuery(Input.optional(page)))
}
