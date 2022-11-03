package com.github.cesar1287.challengecstv.features.home.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.github.cesar1287.challengecstv.api.PandaScoreApi
import com.github.cesar1287.challengecstv.model.Match
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface HomeRepository {

    fun getMatches(): Flow<PagingData<Match>>
}

class HomeRepositoryImpl @Inject constructor(
    private val pandaScoreApi: PandaScoreApi
): HomeRepository {

    override fun getMatches(): Flow<PagingData<Match>> {
        return Pager(
            config = PagingConfig(
                pageSize = 25,
                enablePlaceholders = false
            )
        ) {
            MatchesPagingSource(service = pandaScoreApi)
        }.flow
    }
}