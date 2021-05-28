package com.pan.app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.pan.app.buttons.ButtonsActivity
import com.pan.app.edittext.EditTextActivity
import com.pan.app.items.ImageInfoItem.ImageInfoItemActivity
import com.pan.app.items.SummaryItem.SummaryItemActivity
import com.pan.app.labels.LabelsActivity
import com.pan.app.radiogroup.RadioGroupActivity
import com.pan.app.seekbar.SliderActivity
import com.pan.app.toolbar.ToolbarsActivity

class ComponentsAdapter(private val components: List<String>, val context: Context) :
    RecyclerView.Adapter<ComponentsAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvName: TextView
        val content: ConstraintLayout

        init {
            tvName = view.findViewById(R.id.tvName)
            content = view.findViewById(R.id.content)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_adapter_component, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvName.text = components[position]

        viewHolder.content.setOnClickListener {
            when(position) {
                0 -> context.startActivity(Intent(context, ToolbarsActivity::class.java))
                1 -> context.startActivity(Intent(context, ButtonsActivity::class.java))
                2 -> context.startActivity(Intent(context, LabelsActivity::class.java))
                3 -> context.startActivity(Intent(context, SliderActivity::class.java))
                4 -> context.startActivity(Intent(context, EditTextActivity::class.java))
                5 -> context.startActivity(Intent(context, RadioGroupActivity::class.java))
                6 -> context.startActivity(Intent(context, SummaryItemActivity::class.java))
                7 -> context.startActivity(Intent(context, ImageInfoItemActivity::class.java))
            }
        }
    }

    override fun getItemCount() = components.size
}