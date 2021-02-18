package com.hb.rickandmortyapollo.di

import com.hb.rickandmortyapollo.presentation.characters.CharactersViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule = module {
    viewModel { CharactersViewModel(get()) }
}
