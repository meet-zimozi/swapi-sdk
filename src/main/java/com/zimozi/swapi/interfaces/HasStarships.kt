package com.zimozi.swapi.interfaces
import com.zimozi.swapi.extensions.parallelMap
import com.zimozi.swapi.swapiClient

/**
 * Something which has a relation with starships.
 */
interface HasStarships {
    val starshipsURLs: List<String>

    suspend fun starships() = starshipsURLs.parallelMap { swapiClient.starship(it) }
}
