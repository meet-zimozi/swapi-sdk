package com.zimozi.swapi.interfaces
import com.zimozi.swapi.swapiClient

/**
 * Something which has a homeworld.
 */
interface HasHomeworld {
    val homeworldURL: String?

    suspend fun homeworld() = homeworldURL?.let { swapiClient.planet(it) }
}
