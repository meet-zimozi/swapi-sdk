package com.zimozi.swapi.interfaces
import com.zimozi.swapi.extensions.parallelMap
import com.zimozi.swapi.swapiClient

/**
 * Something which has a relation with species.
 */
interface HasSpecies {
    val speciesURLs: List<String>

    suspend fun species() = speciesURLs.parallelMap { swapiClient.specie(it) }
}
