package com.zimozi.swapi.interfaces
import com.zimozi.swapi.models.SkinColor
import kotlinx.android.parcel.IgnoredOnParcel
import com.zimozi.swapi.extensions.asCSVList

import java.util.Locale

/**
 * Something which has a set of skin colors.
 */
interface HasSkinColors {
    val rawSkinColors: String

    @IgnoredOnParcel
    val skinColors: List<SkinColor>
        get() {
            val values = SkinColor.values()

            return rawSkinColors.asCSVList().map { value ->
                values.firstOrNull { it.rawValue == value.toLowerCase(Locale.getDefault()) }
                    ?: SkinColor.Unknown
            }
        }
}
