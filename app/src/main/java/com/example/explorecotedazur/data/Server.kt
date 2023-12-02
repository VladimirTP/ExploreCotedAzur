package com.example.explorecotedazur.data

import com.example.explorecotedazur.R
import com.example.explorecotedazur.data.models.MainCategoriesResponse
import javax.inject.Inject

class Server @Inject constructor() {

    suspend fun getMainCategories(): List<MainCategoriesResponse> {
        return listOf(
            MainCategoriesResponse(
                R.drawable.main_cafe,
                "Cafes"
            ),
            MainCategoriesResponse(
                R.drawable.main_events,
                "Events"
            ),
            MainCategoriesResponse(
                R.drawable.main_yacht,
                "Yacht Renting"
            ),
            MainCategoriesResponse(
                R.drawable.main_best_places,
                "Best places"
            )
        )
    }

    fun getCafes() {

    }
}