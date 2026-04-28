package com.mateuszholik.common.managers

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.mateuszholik.model.Theme
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

interface ThemeManager {
    val theme: Flow<Theme>
    suspend fun saveTheme(theme: Theme)
}

private val Context.dataStore by preferencesDataStore(name = "settings")

@Singleton
class ThemeManagerImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ThemeManager {

    private val themeKey = stringPreferencesKey("theme")

    override val theme: Flow<Theme> = context.dataStore.data.map { preferences ->
        val themeName = preferences[themeKey] ?: Theme.SYSTEM.name
        Theme.valueOf(themeName)
    }

    override suspend fun saveTheme(theme: Theme) {
        context.dataStore.edit { preferences ->
            preferences[themeKey] = theme.name
        }
    }
}
