package com.github.cesar1287.challengecstv.features.home.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.github.cesar1287.challengecstv.api.PandaScoreApi
import com.github.cesar1287.challengecstv.extensions.getRangeApiDate
import com.github.cesar1287.challengecstv.model.MatchVO
import com.github.cesar1287.challengecstv.utils.PandaScoreApi.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

interface HomeRepository {

    fun getMatches(): Flow<PagingData<MatchVO>>
}

class HomeRepositoryImpl @Inject constructor(
    private val pandaScoreApi: PandaScoreApi,
    private val homeMapper: HomeMapper
): HomeRepository {

    override fun getMatches(): Flow<PagingData<MatchVO>> {
        return Pager(
            config = PagingConfig(
                pageSize = ITEMS_PER_PAGE,
                enablePlaceholders = false
            )
        ) {
            MatchesPagingSource(
                service = pandaScoreApi,
                range = getApiDatesRange(),
                homeMapper = homeMapper
            )
        }.flow
    }

    /*
    * We can use `rangeOfMonths` as a remote config to have a better personalized way to get faster
    * answers from backend, based on user usage, if the overall user never see more than 4/5 pages
    * isn't necessary get a range of matches between 1 year.
    * */
    private fun getApiDatesRange(
        rangeOfMonths: Int? = null
    ): Pair<String, String> {
        val currentDate = Calendar.getInstance()
        val initialDate = Calendar.getInstance()
        initialDate.add(Calendar.MONTH, -(rangeOfMonths ?: 12))

        val firstDate = initialDate.time.getRangeApiDate()
        val secondDate = currentDate.time.getRangeApiDate()
        return Pair(firstDate, secondDate)
    }
}