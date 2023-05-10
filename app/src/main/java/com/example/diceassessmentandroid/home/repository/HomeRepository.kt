package com.example.diceassessmentandroid.home.repository

import com.example.diceassessmentandroid.common.enqueue
import com.example.diceassessmentandroid.home.api.HomeApis
import com.example.diceassessmentandroid.home.model.SearchApiResponseModel
import javax.inject.Inject

class HomeRepository @Inject constructor(private val homeApis: HomeApis) {

    fun getSearchApiResponse(
        quertText :  String,
        sortBy :String,
        orderBy :String,
        success: (searchApiResponseModel: SearchApiResponseModel) -> Unit,
        fail: (error: String) -> Unit
    ) {

        homeApis.getSearchApiReponse(
            quertText,sortBy,orderBy
        ).enqueue {
            onResponse={
                it.body()?.let {
                    success.invoke(it)
                }?: kotlin.run {
                    fail.invoke("Something went wrong")
                }
            }
            onFailure={
                fail.invoke("Something went Wrong")
            }
        }

    }

    fun getSortingByList() : ArrayList<String>{
        return arrayListOf<String>().apply {
            add("Stars")
            add("watchers count")
            add("score")
            add("name")
            add("created_at")
            add("updated_at")
        }

    }
}