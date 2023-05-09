package com.example.diceassessmentandroid.home.viewmodel

import androidx.lifecycle.ViewModel
import com.example.diceassessmentandroid.home.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {

    fun dummytext() = homeRepository.dummyText()
}