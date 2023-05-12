package com.example.diceassessmentandroid.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diceassessmentandroid.common.loadImage
import com.example.diceassessmentandroid.databinding.ItemSearchResultBinding
import com.example.diceassessmentandroid.home.model.Items


class SearchResponseAdapter : ListAdapter<Items, SearchResponseAdapter.ViewHolder>(
    AsyncDifferConfig.Builder(itemDiffCallback).build()
) {
    private var callback : SearchReponseCallback?=null
    private var selectedSortOption = 0

    companion object{
        val itemDiffCallback = object : DiffUtil.ItemCallback<Items>(){
            override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
                return oldItem==newItem
            }
        }
    }

    fun setDataToAdapter(list: List<Items>, callback: SearchReponseCallback?){
        this.submitList(list)
        this.callback=callback
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemSearchResultBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        val lp = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        lp.setMargins(
            20,20,20,20
        )
        view.root.layoutParams = lp
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val itemBinding: ItemSearchResultBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(data : Items){
            itemBinding.ivAvatar.loadImage(
                data.owner?.avatarUrl
            )
            itemBinding.tvUserName.text = data.owner?.login

            itemBinding.tvRepoName.text = data.name
            itemBinding.tvDescription.text = data.description
            itemBinding.tvLangaugeUsed.text = data.language
            itemBinding.tvStarCount.text = data.stargazersCount.toString()

            itemBinding.root.setOnClickListener {
                callback?.searchReponseCallback(data,adapterPosition)
            }
        }
    }
    interface SearchReponseCallback{
        fun searchReponseCallback(str:Items,position: Int)
    }
}