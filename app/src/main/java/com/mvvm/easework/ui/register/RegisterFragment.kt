package com.mvvm.easework.ui.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jem.fliptabs.FlipTab
import com.mvvm.easework.R
import com.mvvm.easework.databinding.RegisterFragmentBinding
import com.mvvm.easework.ui.DashBoardActivity
import com.mvvm.easework.utils.xtnNavigate

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private lateinit var viewModel: RegisterViewModel
    private lateinit var binding: RegisterFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (this::binding.isInitialized.not()) {
            binding = RegisterFragmentBinding.inflate(inflater)
            viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
            handleViews()
        }
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    private fun handleViews() {
        binding.apply {
            ilToolBar.title = "Register"
            ilToolBar.ivBack.setOnClickListener {
                findNavController().popBackStack()
            }

            fliptab.setTabSelectedListener(object : FlipTab.TabSelectedListener {
                override fun onTabReselected(isLeftTab: Boolean, tabTextValue: String) {
                    if (isLeftTab) {
                        customerReg.visibility = View.VISIBLE
                        empolyReg.visibility = View.GONE
                    } else {
                        empolyReg.visibility = View.VISIBLE
                        customerReg.visibility = View.GONE
                    }
                }

                override fun onTabSelected(isLeftTab: Boolean, tabTextValue: String) {
                    if (isLeftTab) {
                        customerReg.visibility = View.VISIBLE
                        empolyReg.visibility = View.GONE
                    } else {
                        empolyReg.visibility = View.VISIBLE
                        customerReg.visibility = View.GONE
                    }
                }

            })
            btnRegister.setOnClickListener {
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