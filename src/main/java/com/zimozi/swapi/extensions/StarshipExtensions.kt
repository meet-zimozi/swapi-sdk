package com.zimozi.swapi.extensions

import com.zimozi.swapi.models.*
import com.zimozi.swapi.swapiClient
import kotlinx.coroutines.coroutineScope

private suspend fun PagedResponse<Starship>.fetch(page: Int?) = page?.let {
    coroutineScope {
        swapiClient.starships(page = it)
    }
}

suspend fun PagedResponse<Starship>.nextPage() = fetch(nextPage)
suspend fun PagedResponse<Starship>.previousPage() = fetch(previousPage)
