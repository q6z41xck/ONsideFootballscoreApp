package com.mateuszholik.footballscore.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mateuszholik.common.managers.ThemeManager
import com.mateuszholik.model.Theme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    themeManager: ThemeManager
) : ViewModel() {

    val theme: StateFlow<Theme> = themeManager.theme
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = Theme.SYSTEM
        )
}
