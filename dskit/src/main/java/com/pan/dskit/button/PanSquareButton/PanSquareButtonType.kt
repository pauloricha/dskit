package com.pan.dskit.button.PanSquareButton

import androidx.annotation.ColorRes
import com.pan.dskit.R

sealed class PanSquareButtonType {
    abstract val color : Int
    abstract val textColor: Int
    abstract val pressedColor : Int
    abstract val disabledColor : Int
    abstract val enabledColor : Int

    companion object {
        const val PRIMARY = 0
        const val SECUNDARY = 1

        fun getTypeByKey(key: Int) = when (key) {
            PRIMARY -> SquareButtonPrimary
            SECUNDARY -> SquareButtonSecundary
            else -> SquareButtonPrimary
        }
    }
}

object SquareButtonPrimary : PanSquareButtonType() {
    @ColorRes
    override val pressedColor : Int = R.color.dodger_blue
    override val disabledColor : Int = R.color.dodger_blue
    override val enabledColor : Int = R.color.dodger_blue
    override val color: Int = R.color.dodger_blue
    override val textColor: Int = R.color.white
}

object SquareButtonSecundary : PanSquareButtonType() {
    @ColorRes
    override val pressedColor : Int = R.color.gray
    override val disabledColor : Int = R.color.gray
    override val enabledColor : Int = R.color.gray
    override val color: Int = R.color.gray
    override val textColor: Int = R.color.white
}