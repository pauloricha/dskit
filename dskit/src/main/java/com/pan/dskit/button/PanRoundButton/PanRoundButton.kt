package com.pan.dskit.button.PanRoundButton

import android.content.Context
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.StateListDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.pan.dskit.R
import com.pan.dskit.compatColor
import com.pan.dskit.handlerAttrs

class PanRoundButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private val button by lazy { findViewById<AppCompatButton>(R.id.round_button)}
    private var buttonText: String? = null
    private var theme: Int = 0

    init {
        View.inflate(this.context, R.layout.pan_round_button, this)
        handleAttr(attrs)
    }

    private fun handleAttr(attrs: AttributeSet?){
        attrs.handlerAttrs(context, R.styleable.PanButton) {
            typedArray, currentAttribute ->
            when(currentAttribute){
                R.styleable.PanButton_theme_button -> {
                    theme = typedArray.getInt(currentAttribute, 0)
                    setTheme(theme)
                }

                R.styleable.PanButton_text_button -> {
                    setTextButton(typedArray.getString(currentAttribute))
                }
            }
        }
    }

    fun setTheme(theme: Int) {
        this.theme = theme
        setupTheme(PanRoundButtonType.getTypeByKey(theme))
    }

    private fun setupTheme(typeButton: PanRoundButtonType) {
        button?.apply {
            setTextColor(ContextCompat.getColor(context, typeButton.textColor))

            background = null

            background = getRoundedDrawable(typeButton.color)
            background = createDrawable(
                context.compatColor(typeButton.enabledColor),
                context.compatColor(typeButton.pressedColor),
                context.compatColor(typeButton.disabledColor)
            )
            invalidate()
        }
    }

    fun setOnClickListener(action: () -> Unit) {
        button?.setOnClickListener { action.invoke() }
    }

    private fun createDrawable(enabled: Int, pressed: Int, disabled: Int) = StateListDrawable().apply {
        addState(
            getStateEnabled(),
            getRoundedDrawable(enabled)
            //ColorDrawable(enabled)
        )

        addState(
            getStatePressed(),
            getRoundedDrawable(pressed)
            //ColorDrawable(pressed)
        )

        addState(
            getStateDisabled(),
            getRoundedDrawable(disabled)
            //ColorDrawable(disabled)
        )
    }

    private fun getRoundedDrawable(color: Int) : ShapeDrawable {
        val radius = FloatArray(8) {
            resources.getDimension(R.dimen.dimen_24)
        }
        val shape = ShapeDrawable()
        shape.shape = RoundRectShape(radius, null, null)
        shape.paint.color = color
        return shape
    }

    private fun getTypeColor(type: Int) : PanRoundButtonType {
        return PanRoundButtonType.getTypeByKey(type)
    }

    fun setTextButton(string: String?){
        string?.let {
            buttonText = it
            button?.text = buttonText
        }
    }

    private fun getStateEnabled() = intArrayOf(-android.R.attr.state_pressed, android.R.attr.state_enabled)
    private fun getStatePressed() = intArrayOf(android.R.attr.state_pressed, android.R.attr.state_enabled)
    private fun getStateDisabled() = intArrayOf(-android.R.attr.state_enabled)
}