package com.pan.dskit.textview.PanLabel

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.pan.dskit.R
import com.pan.dskit.handlerAttrs

class PanLabel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private val label by lazy { findViewById<TextView>(R.id.label)}

    init {
        View.inflate(this.context, R.layout.pan_label, this)
        handleAttr(attrs)
    }

    private fun handleAttr(attrs: AttributeSet?){
        attrs.handlerAttrs(context, R.styleable.PanLabel) {
            typedArray, currentAttribute ->
            when(currentAttribute){
                R.styleable.PanLabel_text_label -> {
                    setTextLabel(typedArray.getString(currentAttribute))
                }

                R.styleable.PanLabel_color_label -> {
                    setTextColor(typedArray.getInt(currentAttribute, 0))
                }

                R.styleable.PanLabel_font_label -> {
                    setFontLabel(typedArray.getInt(currentAttribute, 2))
                }

                R.styleable.PanLabel_align_label -> {
                    setAlignmentLabel(typedArray.getInt(currentAttribute, 0))
                }
            }
        }
    }

    private fun setFontLabel(font: Int?) {
        font?.let {
            val typeface: Typeface? = ResourcesCompat.getFont(context,
                PanFontLabel.getTypeByKey(font).fontLabel)
            label?.setTypeface(typeface);
        }
    }

    fun setTextColor(color: Int?){
        color?.let {
            label?.setTextColor(ContextCompat.getColor(context,
                PanLabelColor.getTypeByKey(color).textColor))
        }
    }

    fun setAlignmentLabel(align: Int?){
        align?.let {
            label?.setTextAlignment(align)
        }
    }

    fun setTextLabel(text: String?){
        text?.let {
            label?.text = text
        }
    }
}