package com.mvvm.easework.ui.request

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mvvm.easework.R
import com.mvvm.easework.databinding.RequestFragmentBinding

class RequestFragment : Fragment() {

    companion object {
        fun newInstance() = RequestFragment()
    }

    private lateinit var viewModel: RequestViewModel
    private lateinit var binding:RequestFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(this::binding.isInitialized.not()){
            binding= RequestFragmentBinding.inflate(inflater)
            viewModel = ViewModelProvider(this).get(RequestViewModel::class.java)
            handleViews()
        }
        binding.lifecycleOwner=this.viewLifecycleOwner
        binding.viewModel=viewModel
        return binding.root
    }

    private fun handleViews() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleObservers()
    }

    private fun handleObservers() {

    }

}