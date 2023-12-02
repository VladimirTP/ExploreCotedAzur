package com.example.explorecotedazur.ui.mainFragments.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.explorecotedazur.databinding.CategoriesMainItemBinding
import com.example.explorecotedazur.domain.models.CategoriesData

class CategoriesAdapter (
    private val categoryList: List<CategoriesData>,
    private val onCategoryClickListener: (CategoriesData) -> Unit
): RecyclerView.Adapter<CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val categoryItemBinding = CategoriesMainItemBinding.inflate(layoutInflater, parent, false)
        return CategoriesViewHolder(categoryItemBinding, onCategoryClickListener)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.onBind(categoryList[position])
    }

    override fun getItemCount(): Int = categoryList.size
}