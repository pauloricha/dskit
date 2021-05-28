package com.pan.dskit.editText.PanEditText

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.SeekBar
import com.pan.dskit.MoneyTextWatcher
import com.pan.dskit.R
import com.pan.dskit.decimalFormatNumericDecimal
import com.pan.dskit.handlerAttrs
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class PanEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private var listener: IPanEditTextListener? = null
    var changedValue: String? = null
    private var minValue: Int = 0
    private var maxValue: Int = 0

    private val edtText by lazy { findViewById<EditText>(R.id.edtText)}

    init {
        View.inflate(this.context, R.layout.pan_edit_text, this)
        handleAttr(attrs)
        //addTextChangedListener(MoneyTextWatcher(edtText))
        onPanEditTextListener()
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

    fun setMinValue(minValue: Int) {
        this.minValue = minValue

        edtText?.apply {
            val currency = (minValue).toDouble().convert()
            setText(decimalFormatNumericDecimal().format(getParsedValue(currency)))
        }
    }

    fun setMaxValue(maxValue: Int) {
        /*seekbar?.apply {
            max = maxValue
        }*/
    }

    fun addTextChangedListener(watcher: TextWatcher) {
        edtText?.addTextChangedListener(watcher)
    }

    fun setOnPanEditTextListener(listener: IPanEditTextListener) {
        this.listener = listener
    }

    private fun onPanEditTextListener() {
        edtText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                try {
                    if(s.isNotEmpty()) {
                        val regexDecimal = Regex("\\D+")
                        val valueClean = s.replace(regexDecimal, "")
                        val maskClean = changedValue?.replace(regexDecimal, "")
                        if(valueClean == maskClean) return
                        val parsed = BigDecimal(valueClean).setScale(2, BigDecimal.ROUND_CEILING)
                                .divide(BigDecimal(100), BigDecimal.ROUND_CEILING)
                        changedValue = decimalFormatNumericDecimal().format(parsed)
                        edtText.setText(decimalFormatNumericDecimal().format(parsed))
                        edtText.setSelection(decimalFormatNumericDecimal().format(parsed).length)
                        listener?.onValueToSimulate(parsed.toInt().toString())
                    }
                } catch (ex: Exception) {
                }
            }
        })
    }

    private fun getParsedValue(s : String): BigDecimal? {
        val regexDecimal = Regex("\\D+")
        val valueClean = s.replace(regexDecimal, "")
        return BigDecimal(valueClean).setScale(2, BigDecimal.ROUND_CEILING)
                .divide(BigDecimal(100), BigDecimal.ROUND_CEILING)
    }


    private fun decimalFormatNumericDecimal() : DecimalFormat {
        val customSymbols = DecimalFormatSymbols()
        customSymbols.decimalSeparator = ','
        customSymbols.groupingSeparator = '.'
        val df = DecimalFormat("R$ ##,##0.00")
        df.decimalFormatSymbols = customSymbols
        return df
    }

    fun Double.convert(): String {
        val format = DecimalFormat(" #,###.00")
        format.isDecimalSeparatorAlwaysShown = false
        return format.format(this).toString()
    }
}