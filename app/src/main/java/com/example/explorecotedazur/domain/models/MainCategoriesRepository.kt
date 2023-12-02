package com.example.explorecotedazur.domain.models

interface MainCategoriesRepository {
    suspend fun getMainCategories(): List<CategoriesData>
}