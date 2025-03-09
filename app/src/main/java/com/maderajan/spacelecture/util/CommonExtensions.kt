package com.maderajan.spacelecture.util

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.Locale

fun Fragment?.toast(@StringRes textRes: Int) {
    Toast.makeText(this?.context, textRes, Toast.LENGTH_SHORT).show()
}

fun String.dayMonthYearReadableDate(): String {
    val apiDate = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault()).parse(this)
    val dateFormat = SimpleDateFormat("dd. mm. yyyy", Locale.getDefault())
    return dateFormat.format(apiDate)
}

fun launchCustomChromeTab(
    context: Context,
    uri: Uri,
) {
    val customTabsIntent = CustomTabsIntent.Builder()
        .build()

    customTabsIntent.launchUrl(context, uri)
}
