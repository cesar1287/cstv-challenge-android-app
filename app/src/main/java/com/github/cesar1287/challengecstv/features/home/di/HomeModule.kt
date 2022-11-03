package com.github.cesar1287.challengeapptvmaze.features.home.di

import com.github.cesar1287.challengeapptvmaze.features.home.data.HomeRepository
import com.github.cesar1287.challengeapptvmaze.features.home.data.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeModule {

    @Binds
    abstract fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository
}