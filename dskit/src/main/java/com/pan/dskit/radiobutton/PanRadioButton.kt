package com.pan.dskit.radiobutton

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.core.content.ContextCompat
import com.pan.dskit.R

class PanRadioButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatRadioButton(context, attrs) {

    init {
        setupComponentColorStyle()
    }

    private fun setupComponentColorStyle() {
        apply {
            setLayerType(View.LAYER_TYPE_HARDWARE, null)
            buttonDrawable = ContextCompat.getDrawable(context, R.drawable.custom_radio_button)
            setTextAppearance(context, R.style.PanRadioButton)
            setPadding(50,0,0,0)
        }
    }
}