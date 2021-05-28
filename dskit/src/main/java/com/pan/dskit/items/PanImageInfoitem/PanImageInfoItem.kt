package com.pan.dskit.items.PanImageInfoitem

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import com.pan.dskit.R
import com.pan.dskit.handlerAttrs

class PanImageInfoItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    val imgInfoItem by lazy { findViewById<AppCompatImageView>(R.id.imgInfoItem)}
    val txtInfoItem by lazy { findViewById<TextView>(R.id.txtInfoItem)}

    init {
        View.inflate(this.context, R.layout.pan_image_info_item, this)
        handleAttr(attrs)
    }

    private fun handleAttr(attrs: AttributeSet?){
        attrs.handlerAttrs(context, R.styleable.PanImageInfoItem) {
            typedArray, currentAttribute ->
            when(currentAttribute){
                R.styleable.PanImageInfoItem_theme_item -> {
                    setTheme(typedArray.getInt(currentAttribute, 0))
                }

                R.styleable.PanImageInfoItem_src_item -> {
                    setImageItem(typedArray.getResourceId(currentAttribute, -1))
                }

                R.styleable.PanImageInfoItem_text_item -> {
                    setTextItem(typedArray.getString(currentAttribute))
                }
            }
        }
    }

    fun setTheme(theme: Int) {
        setupTheme(PanImageInfoItemType.getTypeByKey(theme))
    }

    private fun setupTheme(imageInfoItemType: PanImageInfoItemType) {
        imgInfoItem.setBackground(resources.getDrawable(imageInfoItemType.theme))

    }

    fun setImageItem(@DrawableRes resId: Int?){
        resId?.let {
            imgInfoItem.setImageResource(resId)
        }
    }

    fun setTextItem(text: String?){
        text?.let {
            txtInfoItem.text = text
        }
    }
}