package com.zimozi.swapi.interfaces
import com.zimozi.swapi.models.HairColor
import kotlinx.android.parcel.IgnoredOnParcel
import com.zimozi.swapi.extensions.asCSVList

import java.util.Locale

/**
 * Something which has a set of hair colors.
 */
interface HasHairColors {
    val rawHairColors: String

    @IgnoredOnParcel
    val hairColors: List<HairColor>
        get() {
            val values = HairColor.values()

            return rawHairColors.asCSVList().map { value ->
                values.firstOrNull { it.rawValue == value.toLowerCase(Locale.getDefault()) }
                    ?: HairColor.Unknown
            }
        }
}
