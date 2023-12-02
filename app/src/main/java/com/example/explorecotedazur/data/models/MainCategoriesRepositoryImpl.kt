package com.example.explorecotedazur.data.models

import com.example.explorecotedazur.data.Server
import com.example.explorecotedazur.data.mapper.MainCategoriesMapper
import com.example.explorecotedazur.domain.models.CategoriesData
import com.example.explorecotedazur.domain.models.MainCategoriesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainCategoriesRepositoryImpl @Inject constructor(
    private val server: Server,
    private val mapper: MainCategoriesMapper
) : MainCategoriesRepository {

    override suspend fun getMainCategories(): List<CategoriesData> = withContext(Dispatchers.IO) {server.getMainCategories().map { mapper(it) }}
}