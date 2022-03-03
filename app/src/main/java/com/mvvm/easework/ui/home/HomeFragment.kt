package com.mvvm.easework.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.mvvm.easework.R
import com.mvvm.easework.databinding.HomeFragmentBinding
import com.mvvm.easework.ui.employee.EmployeeFragmentDirections
import com.mvvm.easework.utils.xtnToast

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding
    var catList:ArrayList<CategoryModel> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(this::binding.isInitialized.not()){
            binding= HomeFragmentBinding.inflate(inflater)
            viewModel=ViewModelProvider(this).get(HomeViewModel::class.java)
            handleViews()
        }
        binding.lifecycleOwner=this.viewLifecycleOwner
        binding.viewModel=viewModel
        return binding.root
    }

    private fun handleViews() {
        createCustomData()
        insiliazeAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleObservers()
    }

    private fun handleObservers() {

    }
    private fun insiliazeAdapter() {
        val layoutmanager = GridLayoutManager(context,3)
        binding.apply {
            categoryRecyclerView.layoutManager=layoutmanager
            categoryRecyclerView.adapter=CategoryAdapter{entity, pos ->
                findNavController().navigate(EmployeeFragmentDirections.actionGlobalEmployeeFragment(entity.catName))
            }.apply {
                swapList(catList)
            }
        }
    }
    private fun createCustomData() {
        catList.add(CategoryModel("Iron", R.drawable.iron_board))
        catList.add(CategoryModel("Plumber",R.drawable.plumber))
        catList.add(CategoryModel("Laundry",R.drawable.laundry))
        catList.add(CategoryModel("Electrician",R.drawable.electrician))
        catList.add(CategoryModel("Camera",R.drawable.ic_menu_camera))
        catList.add(CategoryModel("Gallery",R.drawable.ic_menu_gallery))

    }
}