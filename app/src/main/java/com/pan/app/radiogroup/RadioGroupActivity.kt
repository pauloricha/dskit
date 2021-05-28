package com.pan.app.radiogroup

import android.os.Bundle
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.core.view.get
import com.pan.app.R
import com.pan.dskit.seekbar.PanSlider.PanSlider

class RadioGroupActivity : AppCompatActivity() {

    private val radioGroup by lazy { findViewById<RadioGroup>(R.id.radioGroup)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radiogroup)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton by lazy { findViewById<RadioButton>(checkedId)}
            radioButton.text
        }
    }
}