package com.pan.dskit.textview.PanTitleLabel

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.pan.dskit.R
import com.pan.dskit.handlerAttrs

class PanTitleLabel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private val titleLabel by lazy { findViewById<TextView>(R.id.titleLabel)}
    private var color: Int = 0

    init {
        View.inflate(this.context, R.layout.pan_title_label, this)
        handleAttr(attrs)
    }

    private fun handleAttr(attrs: AttributeSet?){
        attrs.handlerAttrs(context, R.styleable.PanLabel) {
            typedArray, currentAttribute ->
            when(currentAttribute){
                R.styleable.PanLabel_color_label -> {
                    color = typedArray.getInt(currentAttribute, 0)
                    setColorLabel(ContextCompat.getColor(context,
                        PanTitleLabelColor.getTypeByKey(color).textColor))
                }

                R.styleable.PanLabel_align_label -> {
                    setAlignmentLabel(typedArray.getInt(currentAttribute, 1))
                }

                R.styleable.PanLabel_text_label -> {
                    setTextLabel(typedArray.getString(currentAttribute))
                }

                R.styleable.PanLabel_size_label -> {
                    setSizeLabel(typedArray.getInt(currentAttribute, 32))
                }
            }
        }
    }

    fun setColorLabel(color: Int?){
        color?.let {
            titleLabel?.setTextColor(color)
        }
    }

    fun setAlignmentLabel(align: Int?){
        align?.let {
            titleLabel?.setTextAlignment(align)
        }
    }

    fun setTextLabel(text: String?){
        text?.let {
            titleLabel?.text = text
        }
    }

    fun setSizeLabel(size: Int?){
        size?.let {
            titleLabel?.setTextSize(TypedValue.COMPLEX_UNIT_SP, size.toFloat())
        }
    }
}