package com.zimozi.swapi.interfaces

import com.zimozi.swapi.models.EyeColor
import kotlinx.android.parcel.IgnoredOnParcel
import com.zimozi.swapi.extensions.asCSVList
import java.util.Locale

/**
 * Something which has a set of eye colors.
 */
interface HasEyeColors {
    val rawEyeColors: String

    @IgnoredOnParcel
    val eyeColors: List<EyeColor>
        get() {
            val values = EyeColor.values()

            return rawEyeColors.asCSVList().map { value ->
                values.firstOrNull { it.rawValue == value.toLowerCase(Locale.getDefault()) }
                    ?: EyeColor.Unknown
            }
        }
}
