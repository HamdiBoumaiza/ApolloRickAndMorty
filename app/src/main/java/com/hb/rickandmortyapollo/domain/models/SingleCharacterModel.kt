package com.hb.rickandmortyapollo.domain.models

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Entity(tableName = "character", primaryKeys = ["id"])
@Parcelize
data class SingleCharacterModel(
    val id: String,
    val name: String,
    val image: String,
    val episode: List<EpisodeModel>
) : Parcelable