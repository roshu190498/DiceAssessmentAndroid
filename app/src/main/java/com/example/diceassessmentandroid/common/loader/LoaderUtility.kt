package com.example.diceassessmentandroid.common.loader

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.example.diceassessmentandroid.R

object LoaderUtility {

    /**
     * Use for common progress bar
     * @param context => not a application context
     * @return Dialog => dialog obj
     */
    fun ShowCommonProgressDialog(context: Context): Dialog {
        val views: View = LayoutInflater.from(context).inflate(R.layout.item_progress_bar, null)
        val dotProgressBar = DotProgressBar.Builder()
            .setAnimationDuration(LOADER_ANIMATION_DURATION)
            .setMaxScale(LOADER_DOTS_MAX_SCALE)
            .setMinScale(LOADER_DOTS_MIN_SCALE)
            .setNumberOfDots(LOADER_NUMBER_OF_DOTS)
            .setdotRadius(LOADER_DOTS_DISTANCE)
            .setColorCodes(arrayListOf(
                ContextCompat.getColor(views.context,R.color.mfp_loader_1),
                ContextCompat.getColor(views.context,R.color.mfp_loader_2),
                ContextCompat.getColor(views.context, R.color.mfp_loader_3)
            ))
            .build(views.context)
        val flView = views.findViewById<FrameLayout>(R.id.frame_layout)
        flView.addView(dotProgressBar)
        dotProgressBar.startAnimation()

        return Dialog(context).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window?.setBackgroundDrawableResource(android.R.color.transparent)
            setContentView(views)
            setCancelable(false)
        }
    }



}