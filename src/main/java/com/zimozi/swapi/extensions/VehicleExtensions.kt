package com.zimozi.swapi.extensions

import com.zimozi.swapi.models.PagedResponse
import com.zimozi.swapi.models.Vehicle
import com.zimozi.swapi.swapiClient
import kotlinx.coroutines.coroutineScope



private suspend fun PagedResponse<Vehicle>.fetch(page: Int?) = page?.let {
    coroutineScope {
        swapiClient.vehicles(page = it)
    }
}

suspend fun PagedResponse<Vehicle>.nextPage() = fetch(nextPage)
suspend fun PagedResponse<Vehicle>.previousPage() = fetch(previousPage)
