package com.mvvm.easework.ui.employee

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm.easework.R
import com.mvvm.easework.databinding.EmployeeFragmentBinding

class EmployeeFragment : Fragment() {

    companion object {
        fun newInstance() = EmployeeFragment()
    }

    private lateinit var viewModel: EmployeeViewModel
    private lateinit var binding: EmployeeFragmentBinding
    private lateinit var category:String
    var employeList:ArrayList<EmployeModel> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(this::binding.isInitialized.not()){
            binding= EmployeeFragmentBinding.inflate(inflater)
            viewModel=ViewModelProvider(this).get(EmployeeViewModel::class.java)
            handleViews()

        }
        binding.lifecycleOwner=this.viewLifecycleOwner
        binding.viewModel=viewModel
        return binding.root
    }

    private fun handleViews() {
    category=EmployeeFragmentArgs.fromBundle(requireArguments()).category
    createCustomData(category)
    insiliazeAdapter()
        binding.apply {
            ilToolBar.title=category
            ilToolBar.ivBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun insiliazeAdapter() {
        val layoutManager=LinearLayoutManager(requireContext())
        binding.apply {
            employeRecycler.layoutManager=layoutManager
            employeRecycler.adapter=EmployeeListAdapter{entity, pos ->
                findNavController().navigate(R.id.action_global_requestFragment)
            }.apply {
                swapList(employeList)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleObservers()
    }

    private fun handleObservers() {

    }
    private fun createCustomData(category: String) {
        for(i in 0..15){
            employeList.add(EmployeModel(category+" "+i,category+" "+i,category+" "+i,category+" "+i))
        }
    }

}