package com.hb.rickandmortyapollo.presentation.characters

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hb.rickandmortyapollo.data.commun.onError
import com.hb.rickandmortyapollo.data.commun.onLoading
import com.hb.rickandmortyapollo.data.commun.onSuccess
import com.hb.rickandmortyapollo.databinding.ActivityCharactersBinding
import com.hb.rickandmortyapollo.domain.models.SingleCharacterModel
import com.hb.rickandmortyapollo.presentation.details.DetailsActivity
import com.hb.rickandmortyapollo.utils.CHARACTER_EXTRA
import com.hb.rickandmortyapollo.utils.hide
import com.hb.rickandmortyapollo.utils.show
import com.hb.rickandmortyapollo.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var binding: ActivityCharactersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharactersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObserver()
        viewModel.getListCharacters(1)
    }

    private fun initObserver() {
        viewModel.resultListCharacters.observe(this) {
            it.onSuccess { list ->
                binding.progressCircular.hide()
                with(binding.rvRickAndMorty) {
                    adapter = CharactersAdapter(list.results) { character ->
                        goToDetailsActivity(character)
                    }
                }
            }.onError { error ->
                binding.progressCircular.hide()
                toast(error.messageResource.toString())
            }.onLoading {
                binding.progressCircular.show()
            }
        }
    }

    private fun goToDetailsActivity(singleCharacterModel: SingleCharacterModel) {
        Intent(this, DetailsActivity::class.java).apply {
            putExtra(CHARACTER_EXTRA, singleCharacterModel)
            startActivity(this)
        }
    }
}