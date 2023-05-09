package com.example.diceassessmentandroid.base

import android.app.Dialog
import android.content.Context
import com.example.diceassessmentandroid.common.loader.LoaderUtility
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ActivityComponent::class)
class BaseActivityModule {
    @Provides
    fun getProgressBar(@ActivityContext context: Context) : Dialog = LoaderUtility.ShowCommonProgressDialog(context)

}