package com.mateuszholik.uicomponents.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.mateuszholik.designsystem.theme.FootballScoreTheme
import com.mateuszholik.designsystem.theme.cornerRadius
import com.mateuszholik.designsystem.theme.spacing
import com.mateuszholik.designsystem.theme.textSizing
import com.mateuszholik.uicomponents.extensions.toEpochSecond
import com.mateuszholik.uicomponents.utils.PreviewConstants
import java.time.LocalDate

@Composable
fun Calendar(
    days: List<LocalDate>,
    selectedDay: LocalDate,
    onDaySelected: (LocalDate) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(modifier = modifier.fillMaxWidth()) {
        itemsIndexed(
            items = days,
            key = { _, date -> date.toEpochSecond() }
        ) { index, day ->
            val dayItemModifier = if (index < days.lastIndex) {
                Modifier.padding(
                    top = MaterialTheme.spacing.small,
                    start = MaterialTheme.spacing.small,
                    bottom = MaterialTheme.spacing.small,
                )
            } else {
                Modifier.padding(MaterialTheme.spacing.small)
            }

            val isSelected = day == selectedDay

            Day(
                modifier = dayItemModifier,
                day = day,
                backgroundColor = if (isSelected) {
                    MaterialTheme.colorScheme.primary
                } else {
                    Color.Transparent
                },
                foregroundColor = if (isSelected) {
                    MaterialTheme.colorScheme.onPrimary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                },
                isEnabled = !isSelected,
                onDaySelected = onDaySelected
            )
        }
    }
}

@Composable
private fun Day(
    modifier: Modifier,
    day: LocalDate,
    backgroundColor: Color,
    foregroundColor: Color,
    isEnabled: Boolean,
    onDaySelected: (LocalDate) -> Unit,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(MaterialTheme.cornerRadius.large))
            .background(backgroundColor)
            .clickable(enabled = isEnabled) { onDaySelected(day) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(
                horizontal = MaterialTheme.spacing.normal,
                vertical = MaterialTheme.spacing.small
            ),
            text = day.asCalendarString(),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = if (backgroundColor != Color.Transparent) FontWeight.Bold else FontWeight.Normal,
            color = foregroundColor
        )
    }
}

@Preview
@Composable
private fun Preview() {
    FootballScoreTheme {
        Calendar(
            days = PreviewConstants.DAYS,
            selectedDay = PreviewConstants.SELECTED_DAY,
            onDaySelected = {}
        )
    }
}
