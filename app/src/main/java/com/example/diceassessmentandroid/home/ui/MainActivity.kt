package com.example.diceassessmentandroid.home.ui

import android.app.Dialog
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.diceassessmentandroid.databinding.ActivityMainBinding
import com.example.diceassessmentandroid.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding :  ActivityMainBinding

    private val homeViewModel : HomeViewModel by viewModels()

    @Inject
    lateinit var progressDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }


    override fun onStart() {
        super.onStart()
        progressDialog.show()
        mBinding.tvTittle.text = homeViewModel.dummytext()
    }
}