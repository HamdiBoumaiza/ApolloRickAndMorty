package com.hb.rickandmortyapollo.mapper

import com.google.common.truth.Truth
import com.hb.rickandmortyapollo.GetCharactersQuery
import com.hb.rickandmortyapollo.data.mappers.mapToDomainModel
import com.hb.rickandmortyapollo.domain.models.SingleCharacterModel
import org.junit.Test

class SingleCharacterMapperTest {

    private val result = GetCharactersQuery.Result(id = "", name = "Rick", image = "url", episode = emptyList())
    private val infoModel: SingleCharacterModel = result.mapToDomainModel()

    @Test
    fun singleCharacterModelMapperTest() {
        Truth.assertThat(infoModel.id).isNotNull()
        Truth.assertThat(infoModel.id).matches("")
        Truth.assertThat(infoModel.name).matches("Rick")
        Truth.assertThat(infoModel.image).matches("url")
        Truth.assertThat(infoModel.episode).isEmpty()
    }
}