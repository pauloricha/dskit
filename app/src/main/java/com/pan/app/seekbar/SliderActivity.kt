package com.pan.app.seekbar

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.pan.app.R
import com.pan.dskit.seekbar.PanSlider.IPanSliderListener
import com.pan.dskit.seekbar.PanSlider.PanSlider
import com.pan.dskit.textview.PanTitleLabel.PanTitleLabel

class SliderActivity : AppCompatActivity() {

    private val txtValuePercentage by lazy { findViewById<PanTitleLabel>(R.id.txtValuePercentage)}
    private val slider by lazy { findViewById<PanSlider>(R.id.slider)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)

        slider.setOnPanSliderListener(object: IPanSliderListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean, progressValue: String) {
                txtValuePercentage.setTextLabel(progressValue)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }
}