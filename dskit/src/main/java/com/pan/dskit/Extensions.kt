package com.pan.dskit

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

inline fun AttributeSet?.handlerAttrs(
    context: Context,
    styleableId: IntArray,
    defStyleAttr: Int = 0,
    onAttributeFound: (TypedArray, Int) -> Unit
) {
    this?.let {
        val typedArray = context.obtainStyledAttributes(it, styleableId, defStyleAttr, defStyleAttr)
        (0 until typedArray.indexCount).forEach {
            onAttributeFound(typedArray, typedArray.getIndex(it))
        }
        typedArray.recycle()
    }
}

fun Context.compatColor(res: Int) = ContextCompat.getColor(this, res)

fun decimalFormatNumericDecimal() : DecimalFormat {
    val customSymbols = DecimalFormatSymbols()
    customSymbols.decimalSeparator = ','
    customSymbols.groupingSeparator = '.'
    val df = DecimalFormat("R$ ##,##0.00")
    df.decimalFormatSymbols = customSymbols
    return df
}
