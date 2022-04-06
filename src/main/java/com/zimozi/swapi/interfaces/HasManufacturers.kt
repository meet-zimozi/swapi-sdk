package com.zimozi.swapi.interfaces

import com.zimozi.swapi.models.Manufacturer
import kotlinx.android.parcel.IgnoredOnParcel
import com.zimozi.swapi.extensions.asLintedLowercaseCSVList
import com.zimozi.swapi.extensions.lintManufacturer


interface HasManufacturers {
    val rawManufacturers: String

    @IgnoredOnParcel
    val manufacturers: List<Manufacturer>
        get() {
            val allValues = Manufacturer.values()

            return rawManufacturers.asLintedLowercaseCSVList()
                .map { rawValue ->
                    allValues.firstOrNull { it.rawValue == rawValue.lintManufacturer() }
                        ?: Manufacturer.Unknown
                }
        }
}
