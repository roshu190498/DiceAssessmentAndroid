package com.example.diceassessmentandroid.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diceassessmentandroid.R
import com.example.diceassessmentandroid.databinding.ItemSortByBinding


class SortingByAdapter : ListAdapter<String, SortingByAdapter.ViewHolder>(
    AsyncDifferConfig.Builder(itemDiffCallback).build()
) {
    private var callback : SortByCallback?=null
    private var selectedSortOption = 0
    companion object{
        val itemDiffCallback = object : DiffUtil.ItemCallback<String>(){
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem==newItem
            }

        }
    }

    fun setDataToAdapter(list: List<String>, callback: SortByCallback?){
        this.submitList(list)
        this.callback=callback
    }

    fun updateAdapter(newPos : Int){
        if (currentList.isEmpty() || selectedSortOption == newPos)
            return
        notifyItemChanged(selectedSortOption)
        notifyItemChanged(newPos)
        selectedSortOption = newPos
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemSortByBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        val lp = RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT)
        lp.setMargins(
            0,
            0,
            20,
            0
        )
        view.root.layoutParams = lp
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val itemBinding: ItemSortByBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(data : String){
            itemBinding.tvTittle.text = data
            if (selectedSortOption == adapterPosition){
                itemBinding.root.background = ResourcesCompat.getDrawable(
                    itemBinding.root.context.resources, R.drawable.ic_rounded_7eb5e8,null
                )
            }else{
                itemBinding.root.background = ResourcesCompat.getDrawable(
                    itemBinding.root.context.resources, R.drawable.ic_rounded_92979a,null
                )
            }
            itemBinding.root.setOnClickListener {
                callback?.sortByClick(data,adapterPosition)
            }
        }
    }
    interface SortByCallback{
        fun sortByClick(str:String,position: Int)
    }
}