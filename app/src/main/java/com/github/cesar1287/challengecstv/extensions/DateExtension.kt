package com.github.cesar1287.challengecstv.extensions

import android.text.format.DateFormat
import android.text.format.DateUtils.isToday
import java.text.SimpleDateFormat
import java.util.*

private const val RANGE_API_DATE_FORMAT = "yyyy-MM-dd"
private const val ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"
private const val UTC_TIME_ZONE = "UTC"
private const val MATCH_CARD_DATE_FORMAT = "dd.MM HH:mm"
private const val MATCH_CARD_DATE_FORMAT_HOUR_ONLY = "HH:mm"

fun Date.getRangeApiDate(): String {
    val simpleDateFormat = SimpleDateFormat(RANGE_API_DATE_FORMAT, Locale.getDefault())
    return simpleDateFormat.format(this)
}

fun String.getPrettyDate(): String {
    //UTC Date - Default
    val utcSimpleDateFormat = SimpleDateFormat(ISO8601_DATE_FORMAT, Locale.getDefault())
    utcSimpleDateFormat.timeZone = TimeZone.getTimeZone(UTC_TIME_ZONE)

    val userDate = utcSimpleDateFormat.parse(this)

    val matchCardSimpleDateFormat = SimpleDateFormat(MATCH_CARD_DATE_FORMAT, Locale.getDefault())
    val matchCardHourOnlySimpleDateFormat = SimpleDateFormat(MATCH_CARD_DATE_FORMAT_HOUR_ONLY, Locale.getDefault())

    return userDate?.let {
        return if (isToday(userDate.time)) {
            "Hoje, ${matchCardHourOnlySimpleDateFormat.format(it)}"
        } else if(isThisWeek(userDate)) {
            "${DateFormat.format("EEE", userDate)}, ${matchCardHourOnlySimpleDateFormat.format(userDate)}"
        } else {
            matchCardSimpleDateFormat.format(it)
        }
    } ?: ""
}

private fun isThisWeek(userDate: Date?): Boolean {
    return userDate?.let {
        val currentDayCalendar = Calendar.getInstance()
        val userDateCalendar = Calendar.getInstance()
        userDateCalendar.time = userDate

        currentDayCalendar.get(Calendar.WEEK_OF_YEAR) ==
                userDateCalendar.get(Calendar.WEEK_OF_YEAR)
    } ?: false
}