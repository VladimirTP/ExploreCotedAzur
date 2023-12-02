package com.example.explorecotedazur.ui.mainFragments.home.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.explorecotedazur.databinding.CategoriesMainItemBinding
import com.example.explorecotedazur.domain.models.CategoriesData

class CategoriesViewHolder (
    private val binding: CategoriesMainItemBinding,
    private val onCategoryClickListener: (CategoriesData) -> Unit
): RecyclerView.ViewHolder(binding.root) {

    fun onBind(item: CategoriesData) {
        with(binding) {
            ivCategory.setImageResource(item.url)

            tvCategoryName.text = item.categoriesName
        }

        itemView.setOnClickListener {
            // Pass the clicked item to the click listener
            onCategoryClickListener.invoke(item)
        }
    }
}