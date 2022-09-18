package com.seymen.retrofitandrecyclerview.presentation.mars_list.adapter

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.seymen.retrofitandrecyclerview.domain.model.MarsModel
import com.seymen.retrofitandrecyclerview.databinding.RecyclerItemBinding

class MarsViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(marsModel: MarsModel, onItemClickHandler: (marsModel: MarsModel) -> Unit){

        val binding = binding as RecyclerItemBinding

        /**
         * Recycler item click listener
         */
        val marsModelClicked = MarsModel(marsModel.id, marsModel.img_src, marsModel.price, marsModel.type)
        binding.root.setOnClickListener { onItemClickHandler(marsModelClicked) }
        binding.setVariable(BR.itemMars, marsModel)
    }
}