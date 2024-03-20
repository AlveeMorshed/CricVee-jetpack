package com.alvee.cricvee_jetpack.domain.utils

import android.icu.util.Calendar
import android.util.Log

private const val TAG = "UtilTools"
object UtilTools {
    var DURATION = getDurationRange()
    var UPCOMING_DURATION = getUpcomingDurationRange()

    fun getDurationRange(): String {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val currentDate = "$year-${month + 1}-$day"

        calendar.add(Calendar.MONTH, -3) //Maximum Nine Months Ago

        val modYear = calendar.get(Calendar.YEAR)
        val modMonth = calendar.get(Calendar.MONTH)
        val modDay = calendar.get(Calendar.DAY_OF_MONTH)
        val threeMonthsBack = "$modYear-${modMonth + 1}-$modDay"

        return "$threeMonthsBack,$currentDate"
    }

    fun getUpcomingDurationRange(): String {
        val calendar = java.util.Calendar.getInstance()
        val year = calendar.get(java.util.Calendar.YEAR)
        val month = calendar.get(java.util.Calendar.MONTH)
        val day = calendar.get(java.util.Calendar.DAY_OF_MONTH)
        val currentDate = "$year-${month + 1}-$day"

        calendar.add(java.util.Calendar.MONTH, +6) //Max 9 months to go

        val modYear = calendar.get(java.util.Calendar.YEAR)
        val modMonth = calendar.get(java.util.Calendar.MONTH)
        val modDay = calendar.get(java.util.Calendar.DAY_OF_MONTH)
        val threeMonthsForward = "$modYear-${modMonth + 1}-$modDay"

        return "$currentDate,$threeMonthsForward"
    }
}