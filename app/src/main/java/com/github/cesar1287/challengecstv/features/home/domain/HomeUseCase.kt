package com.github.cesar1287.challengecstv.features.home.domain

import androidx.paging.PagingData
import com.github.cesar1287.challengecstv.features.home.data.HomeRepository
import com.github.cesar1287.challengecstv.model.Match
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface HomeUseCase {

    fun getMatches(): Flow<PagingData<Match>>
}

class HomeUseCaseImpl @Inject constructor(
    private val homeRepository: HomeRepository
): HomeUseCase {

    override fun getMatches() = homeRepository.getMatches()
}