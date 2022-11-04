package com.github.cesar1287.challengecstv.extensions

import java.text.SimpleDateFormat
import java.util.*

private const val RANGE_API_DATE_FORMAT = "yyyy-MM-dd"

fun Date.getRangeApiDate(): String {
    val simpleDateFormat = SimpleDateFormat(RANGE_API_DATE_FORMAT, Locale.getDefault())
    return simpleDateFormat.format(this)
}