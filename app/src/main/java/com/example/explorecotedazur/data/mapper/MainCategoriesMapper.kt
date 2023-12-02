package com.example.explorecotedazur.data.mapper

import com.example.explorecotedazur.data.models.MainCategoriesResponse
import com.example.explorecotedazur.domain.models.CategoriesData
import javax.inject.Inject

class MainCategoriesMapper @Inject constructor() {

    operator fun invoke(response: MainCategoriesResponse): CategoriesData = with(response) {
        CategoriesData(
            url = url?: 0,
            categoriesName = categoriesName.orEmpty()
        )
    }
}