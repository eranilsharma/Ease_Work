package com.mvvm.easework.ui.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mvvm.easework.R
import com.mvvm.easework.databinding.LoginFragmentBinding
import com.mvvm.easework.ui.DashBoardActivity
import com.mvvm.easework.ui.forgotpwd.ForgotPwdFragmentDirections
import com.mvvm.easework.utils.xtnNavigate

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (this::binding.isInitialized.not()){
            binding= LoginFragmentBinding.inflate(inflater)
            viewModel=ViewModelProvider(this).get(LoginViewModel::class.java)
            handleViews()
        }
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    private fun handleViews() {
        binding.apply {
            txtForgotPassword.setOnClickListener {
                findNavController().navigate(ForgotPwdFragmentDirections.actionGlobalForgotPwdFragment(false))
            }
            lreg.setOnClickListener {
                findNavController().navigate(R.id.action_global_registerFragment)
            }
            txtLoginWithMobile.setOnClickListener {
                findNavController().navigate(ForgotPwdFragmentDirections.actionGlobalForgotPwdFragment(true))
            }
            loginbutton.setOnClickListener {
                requireActivity().xtnNavigate<DashBoardActivity>()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleObservers()
    }

    private fun handleObservers() {

    }

}