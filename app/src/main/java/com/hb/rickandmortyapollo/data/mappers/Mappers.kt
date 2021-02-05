package com.hb.rickandmortyapollo.data.mappers

import com.hb.rickandmortyapollo.GetCharactersQuery
import com.hb.rickandmortyapollo.domain.models.CharactersModel
import com.hb.rickandmortyapollo.domain.models.EpisodeModel
import com.hb.rickandmortyapollo.domain.models.InfoModel
import com.hb.rickandmortyapollo.domain.models.SingleCharacterModel


fun GetCharactersQuery.Info.mapToDomainModel() = InfoModel(pages ?: 0, count ?: 0, next ?: 0)

fun GetCharactersQuery.Episode.mapToDomainModel() = EpisodeModel(id ?: "", name ?: "")

fun GetCharactersQuery.Result.mapToDomainModel() = SingleCharacterModel(
    id ?: "",
    name ?: "",
    image ?: "",
    episode?.map { it!!.mapToDomainModel() } ?: emptyList()
)

fun GetCharactersQuery.Characters.mapToDomainModel() = CharactersModel(
    info?.mapToDomainModel() ?: InfoModel(),
    results?.map { it!!.mapToDomainModel() } ?: emptyList()
)