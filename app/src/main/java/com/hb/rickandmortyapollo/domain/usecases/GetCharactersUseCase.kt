package com.hb.rickandmortyapollo.domain.usecases

import com.hb.rickandmortyapollo.domain.repository.AppRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val appRepository: AppRepository
) {
    suspend operator fun invoke(request: Int) = appRepository.getCharacters(request)
}