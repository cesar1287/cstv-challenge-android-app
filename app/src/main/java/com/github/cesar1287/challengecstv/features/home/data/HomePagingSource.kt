package com.github.cesar1287.challengecstv.features.home.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.cesar1287.challengecstv.api.PandaScoreApi
import com.github.cesar1287.challengecstv.model.Match
import okio.IOException
import retrofit2.HttpException

private const val PANDA_SCORE_STARTING_PAGE_INDEX = 1

class MatchesPagingSource(
    private val service: PandaScoreApi
) : PagingSource<Int, Match>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Match> {
        val pageIndex = params.key ?: PANDA_SCORE_STARTING_PAGE_INDEX
        return try {
            val response = service.getMatches(
                page = pageIndex,
                perPage = 25,
                range = "2021-11-03,2022-11-03",
                sort = "-begin_at,status"
            )
            val movies = response
            val nextKey = params.key?.plus(1)
            LoadResult.Page(
                data = movies,
                prevKey = if (pageIndex == PANDA_SCORE_STARTING_PAGE_INDEX) null else pageIndex,
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
    override fun getRefreshKey(state: PagingState<Int, Match>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index.
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}