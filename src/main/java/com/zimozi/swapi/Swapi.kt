package com.zimozi.swapi

import com.zimozi.swapi.models.*

interface Swapi {
    suspend fun films(page: Int = 1): PagedResponse<Film>
    suspend fun film(url: String): Film

    suspend fun characters(page: Int = 1): PagedResponse<Character>
    suspend fun character(url: String): Character

    suspend fun planets(page: Int = 1): PagedResponse<Planet>
    suspend fun planet(url: String): Planet

    suspend fun species(page: Int = 1): PagedResponse<Specie>
    suspend fun specie(url: String): Specie

    suspend fun vehicles(page: Int = 1): PagedResponse<Vehicle>
    suspend fun vehicle(url: String): Vehicle

    suspend fun starships(page: Int = 1): PagedResponse<Starship>
    suspend fun starship(url: String): Starship
}
