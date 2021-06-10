package com.pan.dskit.textview.PanLabel

import androidx.annotation.FontRes
import com.pan.dskit.R

sealed class PanFontLabel {

    abstract val fontLabel: Int

    companion object {
        const val REGULAR = 0
        const val MEDIUM = 1
        const val SEMIBOLD = 2

        fun getTypeByKey(key: Int) = when (key) {
            REGULAR -> RegularFont
            MEDIUM -> MediumFont
            SEMIBOLD -> SemiBoldFont
            else -> RegularFont
        }
    }
}

object RegularFont : PanFontLabel() {
    @FontRes
    override val fontLabel: Int = R.font.isidora_sans_regular
}

object MediumFont : PanFontLabel() {
    @FontRes
    override val fontLabel: Int = R.font.isidora_sans_medium
}

object SemiBoldFont : PanFontLabel() {
    @FontRes
    override val fontLabel: Int = R.font.isidora_sans_semibold
}