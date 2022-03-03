package com.mvvm.easework.ui

import android.os.Bundle
import com.mvvm.easework.R
import com.mvvm.easework.core.BaseActivity
import com.mvvm.easework.databinding.ActivityPreLoginBinding


class PreLoginActivity : BaseActivity<ActivityPreLoginBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override val layoutId: Int
        get() = R.layout.activity_pre_login

    override fun handleViews() {

    }

    override fun handleObservers() {

    }
}