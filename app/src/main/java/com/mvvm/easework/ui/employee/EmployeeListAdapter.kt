package com.mvvm.easework.ui.employee

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.easework.databinding.SingleEmployeItemBinding

class EmployeeListAdapter(private val onClick: (entity: EmployeModel, pos: Int) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var employeeList = mutableListOf<EmployeModel>()
    fun swapList(list: List<EmployeModel>) {
        this.employeeList.clear()
        this.employeeList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        EmployeeItemVH(
            SingleEmployeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as EmployeeItemVH).bind(employeeList[position])
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    inner class EmployeeItemVH(binding: SingleEmployeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val binding = binding
        fun bind(item: EmployeModel) {
            binding.employee = item
            itemView.setOnClickListener {
                onClick(item, adapterPosition)
                notifyDataSetChanged()
            }
            binding.executePendingBindings()
        }
    }
}