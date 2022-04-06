package com.zimozi.swapi.interfaces
import kotlinx.android.parcel.IgnoredOnParcel
import com.zimozi.swapi.extensions.asCSVList

/**
 * Something which has terrains.
 */
interface HasTerrains {
    val rawTerrains: String

    @IgnoredOnParcel
    val terrains: List<String>
        get() = rawTerrains.asCSVList()
}
