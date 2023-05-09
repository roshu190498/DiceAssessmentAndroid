package com.example.diceassessmentandroid.home.repository

import com.example.diceassessmentandroid.home.api.HomeApis
import javax.inject.Inject

class HomeRepository @Inject constructor(private val homeApis: HomeApis) {

    fun dummyText() = "dummy home page"
}