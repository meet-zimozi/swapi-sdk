package com.zimozi.swapi.extensions

import com.zimozi.swapi.models.Character
import com.zimozi.swapi.models.PagedResponse
import com.zimozi.swapi.swapiClient
import kotlinx.coroutines.coroutineScope


private suspend fun PagedResponse<Character>.fetch(page: Int?) = page?.let {
    coroutineScope {
        swapiClient.characters(page = it)
    }
}

suspend fun PagedResponse<Character>.nextPage() = fetch(nextPage)
suspend fun PagedResponse<Character>.previousPage() = fetch(previousPage)
