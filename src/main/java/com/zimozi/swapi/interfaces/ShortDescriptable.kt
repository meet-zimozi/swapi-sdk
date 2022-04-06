package com.zimozi.swapi.interfaces
import kotlinx.android.parcel.IgnoredOnParcel

/**
 * Something which can be described shortly.
 */
interface ShortDescriptable {
    @IgnoredOnParcel
    val shortDescription: String
}
