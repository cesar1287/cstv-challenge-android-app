package com.github.cesar1287.challengecstv.features.matchdetail.di

import com.github.cesar1287.challengecstv.features.matchdetail.data.MatchDetailRepository
import com.github.cesar1287.challengecstv.features.matchdetail.data.MatchDetailRepositoryImpl
import com.github.cesar1287.challengecstv.features.matchdetail.domain.MatchDetailUseCase
import com.github.cesar1287.challengecstv.features.matchdetail.domain.MatchDetailUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MatchDetailModule {

    @Binds
    abstract fun bindMatchDetailRepository(
        matchDetailRepository: MatchDetailRepositoryImpl
    ): MatchDetailRepository

    @Binds
    abstract fun bindMatchDetailUseCase(
        matchDetailUseCase: MatchDetailUseCaseImpl
    ): MatchDetailUseCase

//    @Binds
//    abstract fun bindHomeMapper(
//        homeMapper: HomeMapperImpl
//    ): HomeMapper
}