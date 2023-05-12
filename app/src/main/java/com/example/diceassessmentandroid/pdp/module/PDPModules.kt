package com.example.diceassessmentandroid.pdp.module

import com.example.diceassessmentandroid.pdp.adapter.PdpDetailsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PDPModules {
    @Provides
    fun providesPdpDetailsAdapter() : PdpDetailsAdapter = PdpDetailsAdapter()
}