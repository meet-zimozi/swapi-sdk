package com.zimozi.swapi.interfaces
import kotlinx.android.parcel.IgnoredOnParcel
import com.zimozi.swapi.extensions.asCSVList

/**
 * Something which has producers.
 */
interface HasProducers {
    val rawProducers: String

    @IgnoredOnParcel
    val producers: List<String>
        get() = rawProducers.asCSVList()
}
