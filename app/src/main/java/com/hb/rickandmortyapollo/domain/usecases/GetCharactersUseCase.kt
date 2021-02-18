package com.hb.rickandmortyapollo.domain.usecases

import com.hb.rickandmortyapollo.domain.repository.AppRepository


class GetCharactersUseCase constructor(
    private val appRepository: AppRepository
) {
    suspend operator fun invoke(request: Int) = appRepository.getCharacters(request)
}