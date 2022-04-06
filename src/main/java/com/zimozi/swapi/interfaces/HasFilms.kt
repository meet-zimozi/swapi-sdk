package com.zimozi.swapi.interfaces
import com.zimozi.swapi.extensions.parallelMap
import com.zimozi.swapi.swapiClient

/**
 * Something which has a relation with films.
 */
interface HasFilms {
    val filmsURLs: List<String>

    suspend fun films() = filmsURLs.parallelMap { swapiClient.film(it) }
}
