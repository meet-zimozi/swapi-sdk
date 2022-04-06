package com.zimozi.swapi.interfaces
import com.zimozi.swapi.extensions.parallelMap
import com.zimozi.swapi.swapiClient

/**
 * Something which has a relation with planets.
 */
interface HasPlanets {
    val planetsURLs: List<String>

    suspend fun planets() = planetsURLs.parallelMap { swapiClient.planet(it) }
}
