package com.zimozi.swapi.extensions

import com.zimozi.swapi.models.*
import com.zimozi.swapi.swapiClient
import kotlinx.coroutines.coroutineScope



private suspend fun PagedResponse<Specie>.fetch(page: Int?) = page?.let {
    coroutineScope {
        swapiClient.species(page = it)
    }
}

suspend fun PagedResponse<Specie>.nextPage() = fetch(nextPage)
suspend fun PagedResponse<Specie>.previousPage() = fetch(previousPage)
