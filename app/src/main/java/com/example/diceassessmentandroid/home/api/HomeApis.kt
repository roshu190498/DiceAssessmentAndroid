package com.example.diceassessmentandroid.home.api

import com.example.diceassessmentandroid.home.model.SearchApiResponseModel
import com.example.diceassessmentandroid.network.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface HomeApis {

    @Headers(
        "Authorization: $API_TOKEN"
    )
    @GET(API_SEARCH)
    fun getSearchApiReponse(
        @Query(QAUERY_PARAM_TEXT) queryText : String,
        @Query(QAUERY_PARAM_SORT) sortBy : String,
        @Query(QAUERY_PARAM_ORDER) orderBy : String,
        ) : Call<SearchApiResponseModel>

}