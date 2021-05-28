package com.pan.dskit.textview.PanTitleLabel

import androidx.annotation.ColorRes
import com.pan.dskit.R

sealed class PanTitleLabelColor {

    abstract val textColor: Int

    companion object {
        const val BLUE = 0
        const val WHITE = 1
        const val BLACK = 2

        fun getTypeByKey(key: Int) = when (key) {
            BLUE -> BlueColor
            WHITE -> WhiteColor
            BLACK -> BlackColor
            else -> BlackColor
        }
    }
}

object BlueColor : PanTitleLabelColor() {
    @ColorRes
    override val textColor: Int = R.color.dodger_blue
}

object WhiteColor : PanTitleLabelColor() {
    @ColorRes
    override val textColor: Int = R.color.white
}

object BlackColor : PanTitleLabelColor() {
    @ColorRes
    override val textColor: Int = R.color.black
}