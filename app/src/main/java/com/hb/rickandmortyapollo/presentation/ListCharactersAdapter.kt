package com.hb.rickandmortyapollo.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hb.rickandmortyapollo.databinding.ItemCharacterBinding
import com.hb.rickandmortyapollo.domain.models.SingleCharacterModel

class ListCharactersAdapter(private val list: List<SingleCharacterModel>) :
    RecyclerView.Adapter<ListCharactersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(private val view: ItemCharacterBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bindTo(singleCharacterModel: SingleCharacterModel) {
            with(view) {
                singleCharacterModel.apply {
                    tvCharacter.text = singleCharacterModel.name
                }
            }
        }
    }
}