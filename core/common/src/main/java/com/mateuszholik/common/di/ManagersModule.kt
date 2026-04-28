package com.mateuszholik.common.di

import com.mateuszholik.common.managers.ThemeManager
import com.mateuszholik.common.managers.ThemeManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ManagersModule {

    @Binds
    @Singleton
    abstract fun bindThemeManager(themeManagerImpl: ThemeManagerImpl): ThemeManager
}
