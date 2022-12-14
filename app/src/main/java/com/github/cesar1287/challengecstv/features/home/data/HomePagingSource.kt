package com.github.cesar1287.challengecstv.features.home.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.cesar1287.challengecstv.api.PandaScoreApi
import com.github.cesar1287.challengecstv.model.MatchVO
import com.github.cesar1287.challengecstv.utils.PandaScoreApi.BEGIN_AT_FIELD
import com.github.cesar1287.challengecstv.utils.PandaScoreApi.ITEMS_PER_PAGE
import com.github.cesar1287.challengecstv.utils.PandaScoreApi.STARTING_PAGE_INDEX
import com.github.cesar1287.challengecstv.utils.PandaScoreApi.STATUS_FIELD
import okio.IOException
import retrofit2.HttpException

class MatchesPagingSource(
    private val service: PandaScoreApi,
    private val range: Pair<String, String>,
    private val homeMapper: HomeMapper
) : PagingSource<Int, MatchVO>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MatchVO> {
        val pageIndex = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = service.getMatches(
                page = pageIndex,
                perPage = ITEMS_PER_PAGE,
                range = "${range.first},${range.second}",
                sort = "-$STATUS_FIELD,-$BEGIN_AT_FIELD"
            )
            val nextKey = params.key?.plus(1)
                ?: (STARTING_PAGE_INDEX + 1)
            LoadResult.Page(
                data = response.map {
                    homeMapper.matchToMatchVO(it)
                },
                prevKey = if (pageIndex == STARTING_PAGE_INDEX) null else pageIndex,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    /**
     * The refresh key is used for subsequent calls to PagingSource.Load after the initial load.
     */
    override fun getRefreshKey(state: PagingState<Int, MatchVO>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index.
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}