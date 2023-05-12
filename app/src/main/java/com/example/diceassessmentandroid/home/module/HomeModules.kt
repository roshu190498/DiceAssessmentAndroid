package com.example.diceassessmentandroid.home.module

import com.example.diceassessmentandroid.home.adapter.SearchResponseAdapter
import com.example.diceassessmentandroid.home.adapter.SortingByAdapter
import com.example.diceassessmentandroid.home.api.HomeApis
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
class HomeModules {
    @Provides
    fun providesHomeApis(retrofit: Retrofit) : HomeApis = retrofit.create(HomeApis::class.java)

    @Provides
    fun providesSortingAdapter() : SortingByAdapter = SortingByAdapter()

    @Provides
    fun providesSearchResponseAdapter() : SearchResponseAdapter = SearchResponseAdapter()
}