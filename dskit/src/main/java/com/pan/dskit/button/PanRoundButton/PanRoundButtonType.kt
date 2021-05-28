package com.pan.dskit.button.PanRoundButton

import androidx.annotation.ColorRes
import com.pan.dskit.R

sealed class PanRoundButtonType {
    abstract val color : Int
    abstract val textColor: Int
    abstract val pressedColor : Int
    abstract val disabledColor : Int
    abstract val enabledColor : Int

    companion object {
        const val PRIMARY = 0
        const val SECUNDARY = 1

        fun getTypeByKey(key: Int) = when (key) {
            PRIMARY -> RoundButtonPrimary
            SECUNDARY -> RoundButtonSecundary
            else -> RoundButtonPrimary
        }
    }
}

object RoundButtonPrimary : PanRoundButtonType() {
    @ColorRes
    override val pressedColor : Int = R.color.dodger_blue
    override val disabledColor : Int = R.color.dodger_blue
    override val enabledColor : Int = R.color.dodger_blue
    override val color: Int = R.color.dodger_blue
    override val textColor: Int = R.color.white
}

object RoundButtonSecundary : PanRoundButtonType() {
    @ColorRes
    override val pressedColor : Int = R.color.white
    override val disabledColor : Int = R.color.white
    override val enabledColor : Int = R.color.white
    override val color: Int = R.color.white
    override val textColor: Int = R.color.black
}