package com.darienalvarez.codechallenge.ui.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import timber.log.Timber
import java.text.NumberFormat
import java.util.*

private val formatter = NumberFormat.getCurrencyInstance().apply {
    maximumFractionDigits = 2
    currency = Currency.getInstance("USD")
}

@BindingAdapter("dollars")
fun TextView.setDollarsBinding(value: Double) {
    text = try {
        formatter.format(value)
    } catch(e: Exception) {
        Timber.e(e)
        ""
    }
}