package com.hb.rickandmortyapollo.viewModels.characters

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.hb.rickandmortyapollo.data.commun.onError
import com.hb.rickandmortyapollo.data.commun.onSuccess
import com.hb.rickandmortyapollo.datasource.RemoteDataSourceImplTest
import com.hb.rickandmortyapollo.domain.usecases.GetCharactersUseCase
import com.hb.rickandmortyapollo.helpers.MainCoroutineRule
import com.hb.rickandmortyapollo.helpers.runBlockingTest
import com.hb.rickandmortyapollo.presentation.characters.CharactersViewModel
import com.hb.rickandmortyapollo.repository.AppRepositoryImplTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SearchCharactersViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: CharactersViewModel

    @Before
    fun setup() {
        viewModel = CharactersViewModel(
            GetCharactersUseCase(AppRepositoryImplTest(RemoteDataSourceImplTest()))
        )
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `get list characters , returns success`() = mainCoroutineRule.runBlockingTest {
        viewModel.getListCharacters(1)

        viewModel.resultListCharacters.value?.onSuccess { result ->
            assertThat(result.info).isNotNull()
            assertThat(result.info.next).isEqualTo(2)
            assertThat(result.results).isNotNull()
            assertThat(result.results[0].name).matches("Rick Sanchez")
            assertThat(result.results[0].episode.size).isAtLeast(5)
        }?.onError { error ->
            assertThat(error).isNull()
        }

    }
}