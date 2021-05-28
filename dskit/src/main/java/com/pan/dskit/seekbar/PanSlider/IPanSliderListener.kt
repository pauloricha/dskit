package com.pan.dskit.seekbar.PanSlider

import android.widget.SeekBar

interface IPanSliderListener {
    fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean, progressValue: String)
    fun onStartTrackingTouch(seekBar: SeekBar?)
    fun onStopTrackingTouch(seekBar: SeekBar?)
}