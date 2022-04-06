package com.zimozi.swapi.interfaces
import com.zimozi.swapi.extensions.parallelMap
import com.zimozi.swapi.swapiClient

/**
 * Something which has a relation with vehicles.
 */
interface HasVehicles {
    val vehiclesURLs: List<String>

    suspend fun vehicles() = vehiclesURLs.parallelMap { swapiClient.vehicle(it) }
}
