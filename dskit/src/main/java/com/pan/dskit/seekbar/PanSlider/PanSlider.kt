package com.pan.dskit.seekbar.PanSlider

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.SeekBar
import com.pan.dskit.R
import com.pan.dskit.handlerAttrs

class PanSlider @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private var listener: IPanSliderListener? = null

    private val seekbar by lazy { findViewById<SeekBar>(R.id.seekbar)}
    private var minValue: Int = 0
    private var maxValue: Int = 0
    private var progressValue: String = "0"

    init {
        View.inflate(this.context, R.layout.pan_slider, this)
        handleAttr(attrs)
        onPanSliderListener()
    }

    private fun handleAttr(attrs: AttributeSet?){
        attrs.handlerAttrs(context, R.styleable.PanValue) {
            typedArray, currentAttribute ->
            when(currentAttribute){
                R.styleable.PanValue_min_value -> {
                    minValue = typedArray.getInt(currentAttribute, 0)
                    setMinValue(minValue)
                }
                R.styleable.PanValue_max_value -> {
                    maxValue = typedArray.getInt(currentAttribute, 0)
                    setMaxValue(maxValue)
                }
            }
        }
    }

    fun setOnPanSliderListener(listener: IPanSliderListener) {
        this.listener = listener
    }

    fun setMinValue(minValue: Int) {
        seekbar?.apply {
            min = minValue
        }
    }

    fun setMaxValue(maxValue: Int) {
        seekbar?.apply {
            max = maxValue
        }
    }

    private fun onPanSliderListener() {
        seekbar?.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                progressValue = progress.toString()
                listener?.onStartTrackingTouch(seekBar)
                listener?.onProgressChanged(seekBar, progress, fromUser, progressValue)
                listener?.onStopTrackingTouch(seekBar)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }
}