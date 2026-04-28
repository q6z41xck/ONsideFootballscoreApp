package com.mateuszholik.uicomponents.calendar

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mateuszholik.designsystem.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
internal fun LocalDate.asCalendarString(): String {
    val today = LocalDate.now()
    val yesterday = today.minusDays(1)
    val tomorrow = today.plusDays(1)

    return when (this) {
        today -> stringResource(R.string.calendar_today)
        yesterday -> stringResource(R.string.calendar_yesterday)
        tomorrow -> stringResource(R.string.calendar_tomorrow)
        else -> {
            val dateTimeFormatter = DateTimeFormatter.ofPattern("EEE dd MMM", Locale.ENGLISH)
            this.format(dateTimeFormatter)
        }
    }
}
