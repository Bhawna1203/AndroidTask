package com.example.taskwork.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.taskwork.dao.ItemDao
import com.example.taskwork.model.Item
import kotlinx.coroutines.delay

/*
This class inherits from PagingSource:
We pass an Int as the first parameter since the
pages are differentiated based on pages (1st Page, 2nd Page, and so on).
We pass an Item as the second parameter since the data we are
handling here is of type Item.
 */
class MainPagingSource(
    private val dao: ItemDao
) : PagingSource<Int, Item>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        val page = params.key ?: 0

        return try {
            val entities = dao.getPagedList(params.loadSize, page * params.loadSize)

            // simulate page loading
            if (page != 0) delay(1000)

            LoadResult.Page(
                data = entities,
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (entities.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}