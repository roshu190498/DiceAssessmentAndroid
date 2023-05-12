package com.example.diceassessmentandroid.pdp.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.diceassessmentandroid.common.loadImage
import com.example.diceassessmentandroid.databinding.ActivityPdpactivityBinding
import com.example.diceassessmentandroid.home.model.Items
import com.example.diceassessmentandroid.pdp.adapter.PdpDetailsAdapter
import com.example.diceassessmentandroid.pdp.viewmodel.PDPViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class PDPActivity : AppCompatActivity() {

    lateinit var mBinding : ActivityPdpactivityBinding

    @Inject
    lateinit var pdpDetailsAdapter: PdpDetailsAdapter

    private val pdpViewModel : PDPViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPdpactivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initviews()
    }

    private fun initviews() {
        handleIntent()
        initUserSection()
        setupAdapter()
        setclicks()
    }

    private fun setclicks() {
        mBinding.tvKnowMore.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(pdpViewModel.selectedItem?.htmlUrl))
            startActivity(browserIntent)
        }
    }

    private fun initUserSection() {
        mBinding.ivAvatar.loadImage(
            pdpViewModel.selectedItem?.owner?.avatarUrl
        )
        mBinding.tvRepoUrl.text = pdpViewModel.selectedItem?.fullName
        mBinding.tvUserType.text = pdpViewModel.selectedItem?.owner?.type

    }

    private fun handleIntent() {
        intent?.extras?.getParcelable<Items>("DATA")?.let {
            pdpViewModel.selectedItem = it
        }
    }

    private fun setupAdapter() {
        mBinding.rvOtherDetails.adapter = pdpDetailsAdapter
        val list = pdpViewModel.getDataForList()
        pdpDetailsAdapter.submitList(list)
    }


}