package com.hb.rickandmortyapollo.data.commun

import com.apollographql.apollo.api.Error

sealed class DataSourceException(
    val messageResource: Any?
) : RuntimeException() {

    class Connection(messageResource: Int) : DataSourceException(messageResource)

    class Unexpected(messageResource: Any?) : DataSourceException(messageResource)

    class Timeout(messageResource: Int) : DataSourceException(messageResource)

    class Client(messageResource: List<Error>?) : DataSourceException(messageResource)

    class Server(messageResource: Int) : DataSourceException(messageResource)
}