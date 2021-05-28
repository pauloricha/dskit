package com.pan.app

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class DSKitActivity : AppCompatActivity() {

    private val rvComponents by lazy { findViewById<RecyclerView>(R.id.rvComponents)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        setContentView(R.layout.activity_dskit)

        val components: ArrayList<String>? = null
        components?.add("Botões")

        rvComponents.layoutManager = LinearLayoutManager(this)
        rvComponents.adapter = ComponentsAdapter(components(), this)
    }

    private fun components(): List<String> {
        return listOf(
            "Toolbar",
            "Buttons",
            "Labels",
            "Slider",
            "EditText",
            "RadioGroup",
            "SummaryItems",
            "ImageInfoItems")
    }
}