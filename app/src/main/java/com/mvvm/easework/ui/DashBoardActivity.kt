package com.mvvm.easework.ui

import android.os.Bundle
import androidx.navigation.NavController
import com.mvvm.easework.R
import com.mvvm.easework.core.BaseActivity
import com.mvvm.easework.databinding.ActivityDashboardBinding


class DashBoardActivity : BaseActivity<ActivityDashboardBinding>() {


    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override val layoutId = R.layout.activity_dashboard

    override fun handleViews() {

        binding.apply {

        }
    }

    override fun handleObservers() {

    }

}

