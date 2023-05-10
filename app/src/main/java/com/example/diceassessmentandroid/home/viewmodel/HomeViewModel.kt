package com.example.diceassessmentandroid.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diceassessmentandroid.common.ResponseData
import com.example.diceassessmentandroid.common.setError
import com.example.diceassessmentandroid.common.setLoading
import com.example.diceassessmentandroid.common.setSuccess
import com.example.diceassessmentandroid.home.model.SearchApiResponseModel
import com.example.diceassessmentandroid.home.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(private val homeRepository: HomeRepository) : ViewModel() {

    val searchApiResponse = MutableLiveData<ResponseData<SearchApiResponseModel>>()
    fun getTopHeadLine(searchQuery : String, sortBy :String , orderBy : String) {
        searchApiResponse.setLoading(null)
        viewModelScope.launch(Dispatchers.IO) {
            homeRepository.getSearchApiResponse(
                searchQuery,sortBy,orderBy,
                {success-> searchApiResponse.setSuccess(success)},
                {error-> searchApiResponse.setError(error)})
        }
    }

}