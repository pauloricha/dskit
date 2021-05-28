package com.pan.dskit.button.PanLinkButton

import androidx.annotation.ColorRes
import com.pan.dskit.R

sealed class PanLinkButtonType {
    abstract val textColor: Int

    companion object {
        const val PRIMARY = 0
        const val SECUNDARY = 1

        fun getTypeByKey(key: Int) = when (key) {
            PRIMARY -> LinkButtonPrimary
            SECUNDARY -> LinkButtonSecundary
            else -> LinkButtonPrimary
        }
    }
}

object LinkButtonPrimary : PanLinkButtonType() {
    @ColorRes
    override val textColor: Int = R.color.black
}

object LinkButtonSecundary : PanLinkButtonType() {
    @ColorRes
    override val textColor: Int = R.color.white
}