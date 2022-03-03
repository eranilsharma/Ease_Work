package com.mvvm.easework.ui.forgotpwd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mvvm.easework.R
import com.mvvm.easework.databinding.ForgotPwdFragmentBinding
import com.mvvm.easework.ui.DashBoardActivity
import com.mvvm.easework.utils.xtnNavigate

class ForgotPwdFragment : Fragment() {

    companion object {
        fun newInstance() = ForgotPwdFragment()
    }

    private lateinit var viewModel: ForgotPwdViewModel
    private lateinit var binding: ForgotPwdFragmentBinding
    private var isRegister: Boolean = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (this::binding.isInitialized.not()) {
            binding = ForgotPwdFragmentBinding.inflate(inflater)
            viewModel = ViewModelProvider(this).get(ForgotPwdViewModel::class.java)
            handleViews()
        }
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    private fun handleViews() {
        isRegister = ForgotPwdFragmentArgs.fromBundle(requireArguments()).isRegister
        binding.apply {
            if (isRegister) {
                ilToolBar.title = "Login"
                edtMobile.hint = "Enter your mobile no"
            } else {
                ilToolBar.title = "Forgot Password"
                edtMobile.hint = getString(R.string.enter_your_registered_mobile_no)
            }
            btnOtp.setOnClickListener {
                mobileLayout.visibility = View.GONE
                createNewPasswordLayout.visibility = View.GONE
                otpLayout.visibility = View.VISIBLE
            }
            btnOtpSubmit.setOnClickListener {
                if (isRegister) {
                    requireActivity().xtnNavigate<DashBoardActivity>()
                } else {
                    mobileLayout.visibility = View.GONE
                    otpLayout.visibility = View.GONE
                    createNewPasswordLayout.visibility = View.VISIBLE
                }
            }
            btnChangePass.setOnClickListener {
                findNavController().navigate(R.id.action_global_loginFragment)
            }
            ilToolBar.ivBack.setOnClickListener {
                findNavController().popBackStack()
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