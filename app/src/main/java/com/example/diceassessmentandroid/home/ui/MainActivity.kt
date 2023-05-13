package com.example.diceassessmentandroid.home.ui

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.diceassessmentandroid.common.Status
import com.example.diceassessmentandroid.databinding.ActivityMainBinding
import com.example.diceassessmentandroid.home.adapter.SearchResponseAdapter
import com.example.diceassessmentandroid.home.adapter.SortingByAdapter
import com.example.diceassessmentandroid.home.model.Items
import com.example.diceassessmentandroid.home.viewmodel.HomeViewModel
import com.example.diceassessmentandroid.pdp.ui.PDPActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),SortingByAdapter.SortByCallback,SearchResponseAdapter.SearchReponseCallback {

    private lateinit var mBinding :  ActivityMainBinding

    private val homeViewModel : HomeViewModel by viewModels()

    @Inject
    lateinit var progressDialog: Dialog

    @Inject
    lateinit var sortingByAdapter : SortingByAdapter

    @Inject
    lateinit var searchResponseAdapter: SearchResponseAdapter

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
    }

    private fun handleClicks() {
        mBinding.etSearchView.addTextChangedListener {
            if ((it?.length ?: 0) <= 0)
                mBinding.vwForSearch.displayedChild = 0
            else {
                homeViewModel.searchText = it.toString()
                callSearchApi()
            }
        }
    }

    private fun initviews() {
        setupAdapter()

    }

    private fun setupAdapter() {
        mBinding.rvSorting.adapter=sortingByAdapter
        sortingByAdapter.setDataToAdapter(homeViewModel.getSortByList(),this)
        mBinding.rvSearchList.adapter=searchResponseAdapter
    }

    private fun setupObserver() {
        homeViewModel.searchApiResponse.observe(this@MainActivity){
            when (it.status) {
                Status.SUCCESS-> {
                    it?.data?.items?.let {list->
                        mBinding.shLoading.stopShimmer()
                        mBinding.vwForSearch.displayedChild  = 1
                        searchResponseAdapter.setDataToAdapter(list,this)
                    }
                }
                Status.ERROR -> {
                    mBinding.shLoading.stopShimmer()
                    mBinding.vwForSearch.displayedChild = 0
                }
                Status.LOADING -> {
                    mBinding.vwForSearch.displayedChild = 2
                    mBinding.shLoading.startShimmer()
                }
            }
        }
    }

    private fun callSearchApi() {
        homeViewModel.getTopHeadLine()
    }

    override fun sortByClick(str: String, position: Int) {
        sortingByAdapter.updateAdapter(position)
        homeViewModel.sortByParam=str
        callSearchApi()
    }

    override fun searchReponseCallback(data: Items, position: Int) {
        val intent = Intent(this@MainActivity,PDPActivity::class.java).apply {
            putExtra("DATA",data)
        }
        startActivity(intent)
    }
}