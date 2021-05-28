package com.pan.dskit.items.PanSummaryItem

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.pan.dskit.R
import com.pan.dskit.handlerAttrs

class PanSummaryItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    val keyLabel by lazy { findViewById<TextView>(R.id.keyLabel)}
    val valueLabel by lazy { findViewById<TextView>(R.id.valueLabel)}

    init {
        View.inflate(this.context, R.layout.pan_summary_item, this)
        handleAttr(attrs)
    }

    private fun handleAttr(attrs: AttributeSet?){
        attrs.handlerAttrs(context, R.styleable.PanSummaryItem) {
            typedArray, currentAttribute ->
            when(currentAttribute){
                R.styleable.PanSummaryItem_type_summary_item -> {
                    setTheme(typedArray.getInt(currentAttribute, 0))
                }

                R.styleable.PanSummaryItem_text_key_item -> {
                    setTitleText(typedArray.getString(currentAttribute))
                }

                R.styleable.PanSummaryItem_text_value_item -> {
                    setValueText(typedArray.getString(currentAttribute))
                }
            }
        }
    }

    fun setTheme(theme: Int) {
        setupTheme(PanSummaryItemType.getTypeByKey(theme))
    }

    private fun setupTheme(summaryItemType: PanSummaryItemType) {
        keyLabel.setTextColor(ContextCompat.getColor(context, summaryItemType.keyColor))
        valueLabel.setTextColor(ContextCompat.getColor(context, summaryItemType.valueColor))
    }

    fun setTitleText(text: String?){
        text?.let {
            keyLabel?.text = text
        }
    }

    fun setValueText(text: String?){
        text?.let {
            valueLabel?.text = text
        }
    }
}