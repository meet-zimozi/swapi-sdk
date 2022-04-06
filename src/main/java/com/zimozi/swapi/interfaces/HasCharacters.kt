package com.zimozi.swapi.interfaces

import com.zimozi.swapi.extensions.parallelMap
import com.zimozi.swapi.swapiClient

/**
 * Something which has a relation with characters.
 */
interface HasCharacters {
    val charactersURLs: List<String>

    suspend fun characters() = charactersURLs.parallelMap { swapiClient.character(it) }
}
