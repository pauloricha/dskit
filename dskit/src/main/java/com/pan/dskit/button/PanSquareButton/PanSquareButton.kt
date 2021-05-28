package com.pan.dskit.button.PanSquareButton

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.pan.dskit.R
import com.pan.dskit.handlerAttrs

class PanSquareButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private val squareButton by lazy { findViewById<TextView>(R.id.square_button)}

    init {
        View.inflate(this.context, R.layout.pan_square_button, this)
        handleAttr(attrs)
    }

    private fun handleAttr(attrs: AttributeSet?){
        attrs.handlerAttrs(context, R.styleable.PanButton) {
            typedArray, currentAttribute ->
            when(currentAttribute){
                R.styleable.PanButton_text_button -> {
                    setTextButton(typedArray.getString(currentAttribute))
                }

                R.styleable.PanButton_theme_button -> {
                    setTheme(typedArray.getInt(currentAttribute, 0))
                    //isEnableButton(true)
                }
            }
        }
    }

    fun setTextButton(text: String?){
        text?.let {
            squareButton?.text = it
        }
    }

    fun setTheme(theme: Int) {
        setupTheme(PanSquareButtonType.getTypeByKey(theme))
    }

    private fun setupTheme(typeButton: PanSquareButtonType) {
        squareButton?.apply {
            background = null
            setBackgroundColor(ContextCompat.getColor(context, typeButton.color))
            setTextColor(ContextCompat.getColor(context, typeButton.textColor))
        }
    }
}