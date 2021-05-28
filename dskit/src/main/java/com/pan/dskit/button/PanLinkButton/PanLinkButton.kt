package com.pan.dskit.button.PanLinkButton

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.pan.dskit.R
import com.pan.dskit.handlerAttrs

class PanLinkButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private val linkButton by lazy { findViewById<TextView>(R.id.link_button)}
    private var buttonText: String? = null
    private var theme: Int = 0

    init {
        View.inflate(this.context, R.layout.pan_link_button, this)
        handleAttr(attrs)
    }

    private fun handleAttr(attrs: AttributeSet?){
        attrs.handlerAttrs(context, R.styleable.PanButton) {
            typedArray, currentAttribute ->
            when(currentAttribute){
                R.styleable.PanButton_theme_button -> {
                    theme = typedArray.getInt(currentAttribute, 0)
                    setTheme(theme)
                    isEnableButton(true)
                }

                R.styleable.PanButton_text_button -> {
                    setTextButton(typedArray.getString(currentAttribute))
                }
            }
        }
    }

    fun setTheme(theme: Int) {
        this.theme = theme
        setupTheme(PanLinkButtonType.getTypeByKey(theme))
    }

    private fun setupTheme(typeButton: PanLinkButtonType) {
        linkButton?.apply {
            setTextColor(ContextCompat.getColor(context, typeButton.textColor))
            invalidate()
        }
    }

    fun isEnableButton(isEnable: Boolean) {
        linkButton?.isEnabled = isEnabled
    }


    fun setTextButton(string: String?){
        string?.let {
            buttonText = it
            linkButton?.text = buttonText
        }
    }
}