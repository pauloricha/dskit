package com.pan.app.items.ImageInfoItem

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.pan.app.R
import com.pan.dskit.items.PanSummaryItem.PanSummaryItem
import com.pan.dskit.seekbar.PanSlider.PanSlider

class ImageInfoItemActivity : AppCompatActivity() {

    val content by lazy { findViewById<ConstraintLayout>(com.pan.dskit.R.id.content)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_info_items)

       /* val panSummaryItem = PanSummaryItem(this)
        panSummaryItem.setTitleText("Parcelas")
        panSummaryItem.setValueText("24x")
        panSummaryItem.setTheme(0)

        content.addView(panSummaryItem)*/
    }
}