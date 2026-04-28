package com.mateuszholik.uicomponents.extensions

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import com.mateuszholik.model.CompetitionType

internal val CompetitionType.backgroundColorForCompetition: Color
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)

internal val CompetitionType.textColorForCompetition: Color
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.colorScheme.onSurfaceVariant
