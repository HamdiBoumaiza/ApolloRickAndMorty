package com.hb.rickandmortyapollo.domain.models


data class SingleCharacterModel(
    val id: String,
    val name: String,
    val image: String,
    val episode: List<EpisodeModel>
)