package com.pan.dskit.items.PanImageInfoitem

import android.annotation.SuppressLint
import androidx.annotation.ColorRes
import com.pan.dskit.R

sealed class PanImageInfoItemType {
    abstract val theme : Int

    companion object {
        const val PRIMARY = 0
        const val SECUNDARY = 1
        const val TERTIARY = 2

        fun getTypeByKey(key: Int) = when (key) {
            PRIMARY -> ImageInfoItemPrimary
            SECUNDARY -> ImageInfoItemSecundary
            TERTIARY -> ImageInfoItemTertiary
            else -> ImageInfoItemPrimary
        }
    }
}

@SuppressLint("ResourceType")
object ImageInfoItemPrimary : PanImageInfoItemType() {
    @ColorRes
    override val theme : Int = R.drawable.pan_img_circle_primary
}

@SuppressLint("ResourceType")
object ImageInfoItemSecundary : PanImageInfoItemType() {
    @ColorRes
    override val theme : Int = R.drawable.pan_img_circle_secundary
}

@SuppressLint("ResourceType")
object ImageInfoItemTertiary : PanImageInfoItemType() {
    @ColorRes
    override val theme : Int = R.drawable.pan_img_circle_tertiary
}