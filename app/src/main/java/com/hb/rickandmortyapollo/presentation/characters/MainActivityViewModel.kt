package com.hb.rickandmortyapollo.presentation.characters

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hb.rickandmortyapollo.data.commun.RickAndMortyResult
import com.hb.rickandmortyapollo.domain.models.CharactersModel
import com.hb.rickandmortyapollo.domain.usecases.GetCharactersUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivityViewModel @ViewModelInject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _resultListCharacters = MutableLiveData<RickAndMortyResult<CharactersModel>>()
    val resultListCharacters: LiveData<RickAndMortyResult<CharactersModel>> = _resultListCharacters

    fun getListCharacters(page: Int) {
        viewModelScope.launch {
            getCharactersUseCase(page).collect {
                _resultListCharacters.postValue(it)
            }
        }
    }
}