package com.mvvm.easework.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.easework.databinding.SingleCategoryItemBinding

class CategoryAdapter(private val onClick: (entity: CategoryModel, pos: Int) -> Unit):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var catList= mutableListOf<CategoryModel>()
    fun swapList(list: List<CategoryModel>) {
        this.catList.clear()
        this.catList.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryItemVH(
            SingleCategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       (holder as CategoryItemVH).bind(catList[position])
    }

    override fun getItemCount(): Int {
        return catList.size
    }
    inner class CategoryItemVH(binding: SingleCategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val binding = binding
        fun bind(item: CategoryModel) {
            binding.category = item
            itemView.setOnClickListener {
                onClick(item, adapterPosition)
                notifyDataSetChanged()
            }
            binding.executePendingBindings()
        }
    }
}
