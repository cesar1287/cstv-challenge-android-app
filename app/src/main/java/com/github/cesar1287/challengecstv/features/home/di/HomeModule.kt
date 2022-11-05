package com.github.cesar1287.challengecstv.features.home.di

import com.github.cesar1287.challengecstv.features.home.data.HomeMapper
import com.github.cesar1287.challengecstv.features.home.data.HomeMapperImpl
import com.github.cesar1287.challengecstv.features.home.data.HomeRepository
import com.github.cesar1287.challengecstv.features.home.data.HomeRepositoryImpl
import com.github.cesar1287.challengecstv.features.home.domain.HomeUseCase
import com.github.cesar1287.challengecstv.features.home.domain.HomeUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class HomeModule {

    @Binds
    abstract fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository

    @Binds
    abstract fun bindHomeUseCase(
        homeUseCase: HomeUseCaseImpl
    ): HomeUseCase

    @Binds
    abstract fun bindHomeMapper(
        homeMapper: HomeMapperImpl
    ): HomeMapper
}