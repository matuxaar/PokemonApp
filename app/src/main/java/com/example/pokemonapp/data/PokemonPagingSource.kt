package com.example.pokemonapp.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokemonapp.domain.model.Pokemon

typealias PokemonPagerLoader = suspend (pageIndex: Int, pageSize: Int) -> List<Pokemon>

class PokemonPagingSource(
    private val loader: PokemonPagerLoader,
    private val pageSize: Int
) : PagingSource<Int, Pokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val pageIndex = params.key ?: 1

        return try {

            val pokemons = loader.invoke(pageIndex, params.loadSize)

            return LoadResult.Page(
                data = pokemons,
                prevKey = if (pageIndex == 0) null else pageIndex - 1,
                nextKey = if (pokemons.size == params.loadSize) pageIndex
                        + (params.loadSize / pageSize) else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }
}