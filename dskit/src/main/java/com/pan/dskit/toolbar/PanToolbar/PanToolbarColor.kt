package com.pan.dskit.toolbar.PanToolbar

import androidx.annotation.ColorRes
import com.pan.dskit.R

sealed class PanToolbarColor {

    abstract val toolbarColor: Int

    companion object {
        const val BLACK = 0
        const val WHITE = 1

        fun getTypeByKey(key: Int) = when (key) {
            BLACK -> BlackColor
            WHITE -> WhiteColor
            else -> BlackColor
        }
    }
}

object BlackColor : PanToolbarColor() {
    @ColorRes
    override val toolbarColor: Int = R.color.black
}

object WhiteColor : PanToolbarColor() {
    @ColorRes
    override val toolbarColor: Int = R.color.white
}