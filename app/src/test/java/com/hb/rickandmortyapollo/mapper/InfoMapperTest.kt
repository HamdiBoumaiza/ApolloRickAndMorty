package com.hb.rickandmortyapollo.mapper

import com.google.common.truth.Truth
import com.hb.rickandmortyapollo.GetCharactersQuery
import com.hb.rickandmortyapollo.data.mappers.mapToDomainModel
import com.hb.rickandmortyapollo.domain.models.InfoModel
import org.junit.Test

class InfoMapperTest {
    private val info = GetCharactersQuery.Info(pages = null, count = 4, next = 4)
    private val infoModel: InfoModel = info.mapToDomainModel()

    @Test
    fun infoModelMapperTest() {
        Truth.assertThat(infoModel.pages).isNotNull()
        Truth.assertThat(infoModel.next).isAtLeast(0)
        Truth.assertThat(infoModel.count).isGreaterThan(0)
    }
}