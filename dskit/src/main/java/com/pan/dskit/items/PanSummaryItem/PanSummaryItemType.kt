package com.pan.dskit.items.PanSummaryItem

import androidx.annotation.ColorRes
import com.pan.dskit.R

sealed class PanSummaryItemType {
    abstract val titleColor : Int
    abstract val valueColor: Int

    companion object {
        const val PRIMARY = 0
        const val SECUNDARY = 1

        fun getTypeByKey(key: Int) = when (key) {
            PRIMARY -> SummaryItemPrimary
            SECUNDARY -> SummaryItemSecundary
            else -> SummaryItemPrimary
        }
    }
}

object SummaryItemPrimary : PanSummaryItemType() {
    @ColorRes
    override val titleColor : Int = R.color.black
    override val valueColor : Int = R.color.white
}

object SummaryItemSecundary : PanSummaryItemType() {
    @ColorRes
    override val titleColor : Int = R.color.black
    override val valueColor : Int = R.color.black
}