package com.hb.rickandmortyapollo.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class SingleCharacterModel(
    val id: String,
    val name: String,
    val image: String,
    val episode: List<EpisodeModel>
) : Parcelable