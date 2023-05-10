package com.example.diceassessmentandroid.home.ui

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.diceassessmentandroid.common.Status
import com.example.diceassessmentandroid.databinding.ActivityMainBinding
import com.example.diceassessmentandroid.home.adapter.SortingByAdapter
import com.example.diceassessmentandroid.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),SortingByAdapter.SortByCallback {

    private lateinit var mBinding :  ActivityMainBinding

    private val homeViewModel : HomeViewModel by viewModels()

    @Inject
    lateinit var progressDialog: Dialog

    @Inject
    lateinit var sortingByAdapter : SortingByAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }


    override fun onStart() {
        super.onStart()
        initviews()
        handleClicks()
        setupObserver()
        callSearchApi()
    }

    private fun handleClicks() {
        mBinding.etSearchView.addTextChangedListener {
            if ((it?.length ?: 0) <= 0)
                Log.d("TAG_SEARCH","Show Error")
            else
                Log.d("TAG_SEARCH","call API's ${it.toString()}")
        }
    }

    private fun initviews() {
        setupAdapter()

    }

    private fun setupAdapter() {
        mBinding.rvSorting.adapter=sortingByAdapter
        sortingByAdapter.setDataToAdapter(homeViewModel.getSortByList(),this)

    }

    private fun setupObserver() {
        homeViewModel.searchApiResponse.observe(this@MainActivity){
            when (it.status) {
                Status.SUCCESS-> {
                    progressDialog.dismiss()
                }
                Status.ERROR -> {
                    progressDialog.dismiss()
                }
                Status.LOADING -> {
                    progressDialog.show()
                }
            }
        }
    }

    private fun callSearchApi() {
        homeViewModel.getTopHeadLine(
"windows+label:bug \\\n" +
        "+language:python+state:open",
            "created",
            "asc"
        ).also {
            progressDialog.show()
        }
    }

    override fun sortByClick(str: String, position: Int) {

        sortingByAdapter.updateAdapter(position)
    }
}