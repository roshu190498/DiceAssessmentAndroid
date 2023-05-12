package com.example.diceassessmentandroid.pdp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.diceassessmentandroid.home.model.Items
import com.example.diceassessmentandroid.pdp.model.PDPModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PDPViewModel @Inject constructor() :  ViewModel(){

    var selectedItem : Items?=null
    fun getDataForList() : ArrayList<PDPModel>{
        val list = arrayListOf<PDPModel>()
        list.add(PDPModel("Repo Name",selectedItem?.name?:""))
        list.add(PDPModel("Description",selectedItem?.description?:""))
        list.add(PDPModel("Language",selectedItem?.language?:""))
        list.add(PDPModel("Visibility", selectedItem?.visibility?:""))
        list.add(PDPModel("Created At",selectedItem?.createdAt?:""))
        list.add(PDPModel("Updated At",selectedItem?.updatedAt?:""))
        list.add(PDPModel("Clone url",selectedItem?.cloneUrl?:""))
        list.add(PDPModel("Default Branch",selectedItem?.defaultBranch?:""))
        list.add(PDPModel("open issues",selectedItem?.openIssues.toString()))
        list.add(PDPModel("watchers",selectedItem?.watchers.toString()))
        list.add(PDPModel("Stars",selectedItem?.stargazersCount.toString()))
        return list
    }

}