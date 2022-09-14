package com.seymen.retrofitandrecyclerview.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.seymen.retrofitandrecyclerview.data.model.MarsModel
import com.seymen.retrofitandrecyclerview.databinding.RecyclerItemBinding

class MainAdapter(private val marsInfo: ArrayList<MarsModel>) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    private lateinit var binding : RecyclerItemBinding

    class DataViewHolder(val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }
    override fun getItemCount(): Int = marsInfo.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.binding.itemMars = marsInfo[position]
        holder.binding.executePendingBindings()
    }

    fun addInfo(marsInfo: List<MarsModel>) {
        this.marsInfo.apply {
            clear()
            addAll(marsInfo)
        }

    }
}