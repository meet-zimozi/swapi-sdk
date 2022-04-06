package com.zimozi.swapi

import com.squareup.moshi.Types
import com.zimozi.swapi.extensions.asCSVList
import com.zimozi.swapi.extensions.asLintedLowercaseCSVList
import com.zimozi.swapi.extensions.lintManufacturer
import com.zimozi.swapi.models.Manufacturer
import com.zimozi.swapi.models.*
import okio.buffer
import okio.source
import java.util.Locale

fun Any.readJson(fileName: String) = javaClass.classLoader
    ?.getResourceAsStream(fileName)
    ?.source()
    ?.buffer()
    ?.readUtf8()

fun <T : Any> Any.pagedResponse(fileName: String, clazz: Class<T>): PagedResponse<T> {
    val type = Types.newParameterizedType(PagedResponse::class.java, clazz)
    val adapter = moshi.adapter<PagedResponse<T>>(type)

    return readJson(fileName)?.let { adapter.fromJson(it) }
        ?: throw NullPointerException("unable to deserialize $fileName")
}

fun <T : Any> List<PagedResponse<T>>.resultsList() = map { it.results }.flatten()

fun String.mapManufacturersOrFail(): List<Manufacturer> {
    val allValues = Manufacturer.values()

    return asLintedLowercaseCSVList()
        .map { rawValue ->
            allValues.firstOrNull { it.rawValue == rawValue.lintManufacturer() }
                ?: throw IllegalArgumentException("Missing rawValue: $rawValue")
        }
}

fun String.mapEyeColorsOrFail(): List<EyeColor> {
    val values = EyeColor.values()

    return asCSVList().map { value ->
        values.firstOrNull { it.rawValue == value.toLowerCase(Locale.getDefault()) }
            ?: throw IllegalArgumentException("Missing rawValue: $value")
    }
}

fun String.mapSkinColorsOrFail(): List<SkinColor> {
    val values = SkinColor.values()

    return asCSVList().map { value ->
        values.firstOrNull { it.rawValue == value.toLowerCase(Locale.getDefault()) }
            ?: throw IllegalArgumentException("Missing rawValue: $value")
    }
}

fun String.mapHairColorsOrFail(): List<HairColor> {
    val values = HairColor.values()

    return asCSVList().map { value ->
        values.firstOrNull { it.rawValue == value.toLowerCase(Locale.getDefault()) }
            ?: throw IllegalArgumentException("Missing rawValue: $value")
    }
}
