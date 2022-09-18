package com.seymen.retrofitandrecyclerview.presentation.mars_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.seymen.retrofitandrecyclerview.R
import com.seymen.retrofitandrecyclerview.domain.model.MarsModel

class MarsListRecyclerViewAdapter(
    private val marsInfo: ArrayList<MarsModel>,
    private val onItemClickHandler: (marsModel: MarsModel) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val marsBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.recycler_item,
            parent,
            false
        )
        return MarsViewHolder(marsBinding)
    }

    override fun getItemCount(): Int = marsInfo.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as MarsViewHolder).onBind(marsInfo[position], onItemClickHandler)
    }

    fun addInfo(marsInfo: List<MarsModel>) {
        this.marsInfo.apply {
            clear()
            addAll(marsInfo)
        }
    }
}