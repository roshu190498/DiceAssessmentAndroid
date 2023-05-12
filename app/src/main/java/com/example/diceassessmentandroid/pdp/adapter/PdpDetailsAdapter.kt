package com.example.diceassessmentandroid.pdp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diceassessmentandroid.databinding.ItemPdpDatailsBinding
import com.example.diceassessmentandroid.pdp.model.PDPModel


class PdpDetailsAdapter : ListAdapter<PDPModel, PdpDetailsAdapter.ViewHolder>(
    AsyncDifferConfig.Builder(itemDiffCallback).build()
) {
    companion object{
        val itemDiffCallback = object : DiffUtil.ItemCallback<PDPModel>(){
            override fun areItemsTheSame(oldItem: PDPModel, newItem: PDPModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: PDPModel, newItem: PDPModel): Boolean {
                return oldItem==newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemPdpDatailsBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        val lp = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        lp.setMargins(
            0,
            0,
            0,
            20
        )
        view.root.layoutParams = lp
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val itemBinding: ItemPdpDatailsBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(data : PDPModel){
            itemBinding.tvkey.text = data.key
            itemBinding.tvValue.text = data.value
        }
    }
}