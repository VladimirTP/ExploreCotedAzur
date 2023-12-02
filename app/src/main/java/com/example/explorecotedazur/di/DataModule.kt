package com.example.explorecotedazur.di

import com.example.explorecotedazur.data.models.MainCategoriesRepositoryImpl
import com.example.explorecotedazur.domain.models.MainCategoriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule() {

    @Binds
    abstract fun getMainCategories(impl: MainCategoriesRepositoryImpl): MainCategoriesRepository
}