package com.pan.dskit

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

open class MoneyTextWatcher(val editText: EditText) : TextWatcher {
    var changedValue: String? = null

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
                editText.setText(decimalFormatNumericDecimal().format(parsed))
                editText.setSelection(decimalFormatNumericDecimal().format(parsed).length)
            }
        } catch (ex: Exception) {

        }
    }

    private fun decimalFormatNumericDecimal() : DecimalFormat {
        val customSymbols = DecimalFormatSymbols()
        customSymbols.decimalSeparator = ','
        customSymbols.groupingSeparator = '.'
        val df = DecimalFormat("R$ ##,##0.00")
        df.decimalFormatSymbols = customSymbols
        return df
    }
}