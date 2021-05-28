package com.pan.dskit.textview.PanLabel

import androidx.annotation.FontRes
import com.pan.dskit.R

sealed class PanLabelStyle {

    abstract val textStyle: Int

    companion object {
        const val REGULAR = 0
        const val SEMIBOLD = 1

        fun getTypeByKey(key: Int) = when (key) {
            REGULAR -> RegularStyle
            SEMIBOLD -> SemiBoldStyle
            else -> RegularStyle
        }
    }
}

object RegularStyle : PanLabelStyle() {
    @FontRes
    override val textStyle: Int = R.font.isidora_sans_regular
}

object SemiBoldStyle : PanLabelStyle() {
    @FontRes
    override val textStyle: Int = R.font.isidora_sans_semibold
}