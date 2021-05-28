package com.pan.dskit.textview.PanSmallLabel

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
import com.pan.dskit.textview.PanLabel.PanLabelStyle
import com.pan.dskit.textview.PanTitleLabel.PanTitleLabelColor

class PanSmallLabel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private val smallLabel by lazy { findViewById<TextView>(R.id.smallLabel)}

    init {
        View.inflate(this.context, R.layout.pan_small_label, this)
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

                R.styleable.PanLabel_style_label -> {
                    setTextStyle(typedArray.getInt(currentAttribute, 0))
                }

                R.styleable.PanLabel_align_label -> {
                    setAlignmentLabel(typedArray.getInt(currentAttribute, 1))
                }
            }
        }
    }

    private fun setTextStyle(font: Int?) {
        font?.let {
            val typeface: Typeface? = ResourcesCompat.getFont(context,
                PanLabelStyle.getTypeByKey(font).textStyle)
            smallLabel?.setTypeface(typeface);
        }
    }

    fun setTextColor(color: Int?){
        color?.let {
            smallLabel?.setTextColor(ContextCompat.getColor(context,
                PanTitleLabelColor.getTypeByKey(color).textColor))
        }
    }

    fun setTextLabel(text: String?){
        text?.let {
            smallLabel?.text = text
        }
    }

    fun setAlignmentLabel(align: Int?){
        align?.let {
            smallLabel?.setTextAlignment(align)
        }
    }
}