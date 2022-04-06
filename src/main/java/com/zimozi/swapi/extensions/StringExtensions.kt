package com.zimozi.swapi.extensions

import com.zimozi.swapi.SwapiOrigin
import com.zimozi.swapi.models.Manufacturer
import com.zimozi.swapi.swapiClient
import java.util.Locale

fun String.asCSVList() = split(",").map { it.trim() }
fun String.asLintedLowercaseCSVList() = asCSVList()
    .map { it.toLowerCase(Locale.getDefault()) }
    .map { it.split("/") }
    .flatten() // theed palace space vessel engineering corps/nubia star drives

fun String.pageNumber() = if (swapiClient is SwapiOrigin) {
    split("=").getOrNull(1)?.toInt()
} else {
    split("page").getOrNull(1)?.replace(".json", "")?.toInt()
}

internal fun String.lintManufacturer() = when (val linted = replace(".", "")) {
    "incom" -> Manufacturer.IncomCorporation.rawValue

    "inc" -> Manufacturer.Incorporated.rawValue

    "cyngus spaceworks" -> Manufacturer.CygnusSpaceworks.rawValue

    else -> linted
}
