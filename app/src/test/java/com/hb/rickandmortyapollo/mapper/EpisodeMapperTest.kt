package com.hb.rickandmortyapollo.mapper

import com.google.common.truth.Truth
import com.hb.rickandmortyapollo.GetCharactersQuery
import com.hb.rickandmortyapollo.data.mappers.mapToDomainModel
import com.hb.rickandmortyapollo.domain.models.EpisodeModel
import org.junit.Test

class EpisodeMapperTest {
    private val episode = GetCharactersQuery.Episode(id = "12", name = "Pilot")
    private val episodeModel: EpisodeModel = episode.mapToDomainModel()

    @Test
    fun episodeModelMapperTest() {
        Truth.assertThat(episodeModel.id).isNotNull()
        Truth.assertThat(episodeModel.id).matches("12")
        Truth.assertThat(episodeModel.name).isNotEmpty()
        Truth.assertThat(episodeModel.name).matches("Pilot")
    }
}