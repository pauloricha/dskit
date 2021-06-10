package com.pan.app.toolbars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pan.app.R
import com.pan.dskit.toolbar.PanToolbar.PanToolbar

class ToolbarsActivity : AppCompatActivity() {

    private val toolbar by lazy { findViewById<PanToolbar>(R.id.toolbar)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbars)
    }
}