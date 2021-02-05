package com.hb.rickandmortyapollo.data.commun

sealed class RickAndMortyResult<out T> {
    data class Success<out T>(val data: T) : RickAndMortyResult<T>()
    data class Error(val exception: DataSourceException) : RickAndMortyResult<Nothing>()
    object Loading : RickAndMortyResult<Nothing>()
}

inline fun <T : Any> RickAndMortyResult<T>.onSuccess(action: (T) -> Unit): RickAndMortyResult<T> {
    if (this is RickAndMortyResult.Success) action(data)
    return this
}

inline fun <T : Any> RickAndMortyResult<T>.onError(action: (DataSourceException) -> Unit): RickAndMortyResult<T> {
    if (this is RickAndMortyResult.Error) action(exception)
    return this
}

inline fun <T : Any> RickAndMortyResult<T>.onLoading(action: () -> Unit): RickAndMortyResult<T> {
    if (this is RickAndMortyResult.Loading) action()
    return this
}