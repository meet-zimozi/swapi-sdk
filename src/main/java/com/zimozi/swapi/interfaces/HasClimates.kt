package com.zimozi.swapi.interfaces
import kotlinx.android.parcel.IgnoredOnParcel
import com.zimozi.swapi.extensions.asCSVList

/**
 * Something which has climates.
 */
interface HasClimates {
    val rawClimates: String

    @IgnoredOnParcel
    val climates: List<String>
        get() = rawClimates.asCSVList()
}
