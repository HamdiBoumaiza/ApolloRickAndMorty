package com.hb.rickandmortyapollo.domain.models

data class InfoModel(
    val pages: Int,
    val count: Int,
    val next: Int?
) {
    constructor() : this(0, 0, 0)
}