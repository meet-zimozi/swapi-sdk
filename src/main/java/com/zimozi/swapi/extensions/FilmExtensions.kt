package com.zimozi.swapi.extensions

import com.zimozi.swapi.models.Film
import com.zimozi.swapi.models.PagedResponse
import com.zimozi.swapi.swapiClient
import kotlinx.coroutines.coroutineScope


private suspend fun PagedResponse<Film>.fetch(page: Int?) = page?.let {
    coroutineScope {
        swapiClient.films(page = it)
    }
}

suspend fun PagedResponse<Film>.nextPage() = fetch(nextPage)
suspend fun PagedResponse<Film>.previousPage() = fetch(previousPage)
