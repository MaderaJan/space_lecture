package com.maderajan.spacelecture.util

import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.Locale

fun Fragment?.toast(@StringRes textRes: Int) {
    Toast.makeText(this?.context, textRes, Toast.LENGTH_SHORT).show()
}

fun Fragment.composeContent(content: @Composable () -> Unit): View =
    ComposeView(requireContext()).apply {
        setContent {
            content()
        }
    }

fun String.dayMonthYearReadableDate(): String {
    val apiDate = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault()).parse(this)
    val dateFormat = SimpleDateFormat("dd. mm. yyyy", Locale.getDefault())
    return dateFormat.format(apiDate)
}