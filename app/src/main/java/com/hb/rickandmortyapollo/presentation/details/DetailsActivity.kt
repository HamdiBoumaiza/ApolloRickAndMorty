package com.hb.rickandmortyapollo.presentation.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.hb.rickandmortyapollo.R
import com.hb.rickandmortyapollo.databinding.ActivityDetailsBinding
import com.hb.rickandmortyapollo.domain.models.SingleCharacterModel
import com.hb.rickandmortyapollo.utils.CHARACTER_EXTRA
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsActivity : AppCompatActivity() {

    private val viewModel: DetailsActivityViewModel by viewModel()
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtraCharacter()?.let {
            with(binding) {
                imgDetailsCharacter.load(it.image)
                tvDetailsCharacter.text =
                    getString(R.string.characters_episodes_appearance, it.name)
                rvEpisodes.adapter = EpisodesAdapter(it.episode)
            }
        }
    }

    private fun getExtraCharacter() =
        intent?.extras?.getParcelable(CHARACTER_EXTRA) as SingleCharacterModel?


}