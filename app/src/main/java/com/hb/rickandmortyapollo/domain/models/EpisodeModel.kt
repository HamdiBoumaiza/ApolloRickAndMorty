package com.hb.rickandmortyapollo.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class EpisodeModel(
    val id: String,
    val name: String
) : Parcelable