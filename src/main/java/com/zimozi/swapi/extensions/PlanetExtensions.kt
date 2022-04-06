package com.zimozi.swapi.extensions


import com.zimozi.swapi.models.PagedResponse
import com.zimozi.swapi.models.Planet
import com.zimozi.swapi.swapiClient
import kotlinx.coroutines.coroutineScope



private suspend fun PagedResponse<Planet>.fetch(page: Int?) = page?.let {
    coroutineScope {
        swapiClient.planets(page = it)
    }
}

suspend fun PagedResponse<Planet>.nextPage() = fetch(nextPage)
suspend fun PagedResponse<Planet>.previousPage() = fetch(previousPage)
