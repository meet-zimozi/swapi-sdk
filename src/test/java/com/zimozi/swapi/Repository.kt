package com.zimozi.swapi

import com.zimozi.swapi.models.*

fun Any.allPagedFilms() = listOf(pagedResponse("1", Film::class.java))

fun Any.allPagedCharacters() = (1..9).map { number ->
    pagedResponse("people_page$number", Character::class.java)
}

fun Any.allPagedPlanets() = (1..7).map { number ->
    pagedResponse("planets_page$number", Planet::class.java)
}

fun Any.allPagedSpecies() = (1..4).map { number ->
    pagedResponse("species_page$number", Specie::class.java)
}

fun Any.allPagedStarships() = (1..4).map { number ->
    pagedResponse("starships_page$number", Starship::class.java)
}

fun Any.allPagedVehicles() = (1..4).map { number ->
    pagedResponse("vehicles_page$number", Vehicle::class.java)
}
