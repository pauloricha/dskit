package com.pan.dskit.toolbar.PanToolbar

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.pan.dskit.R
import com.pan.dskit.handlerAttrs

class PanToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private val btnBack by lazy { findViewById<AppCompatImageView>(R.id.btnBack)}
    private val btnClose by lazy { findViewById<AppCompatImageView>(R.id.btnClose)}
    private var color: Int = 0

    init {
        View.inflate(this.context, R.layout.pan_toolbar, this)
        handleAttr(attrs)
    }

    private fun handleAttr(attrs: AttributeSet?){
        attrs.handlerAttrs(context, R.styleable.PanToolbar) {
            typedArray, currentAttribute ->
            when(currentAttribute){
                R.styleable.PanToolbar_has_close -> {
                    setLayoutToolbar(typedArray.getInt(currentAttribute, 0))
                }

                R.styleable.PanToolbar_color_toolbar -> {
                    color = typedArray.getInt(currentAttribute, 0)
                    setColorToolbar(ContextCompat.getColor(context,
                        PanToolbarColor.getTypeByKey(color).toolbarColor))
                }
            }
        }
    }

    private fun setLayoutToolbar(visibility: Int) {
        btnClose.visibility = visibility
    }

    fun setColorToolbar(color: Int) {
        btnBack.setColorFilter(color);
        btnClose.setColorFilter(color);
    }

    fun setOnBackClickListener(action: () -> Unit) {
        btnBack?.setOnClickListener {
            action.invoke()
        }
    }

    fun setOnCloseClickListener(action: () -> Unit) {
        btnClose?.setOnClickListener {
            action.invoke()
        }
    }
}