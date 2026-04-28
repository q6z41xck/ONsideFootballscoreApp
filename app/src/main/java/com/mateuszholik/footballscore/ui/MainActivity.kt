package com.mateuszholik.footballscore.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mateuszholik.designsystem.theme.FootballScoreTheme
import com.mateuszholik.model.Theme
import com.mateuszholik.footballscore.navigation.MainNavigation
import com.mateuszholik.footballscore.navigation.MainNavigation.BOTTOM_NAV_ITEMS
import com.mateuszholik.footballscore.navigation.MainNavigation.mainNavigationGraph
import com.mateuszholik.footballscore.navigation.MainNavigation.navigateToBottomNavItem
import com.mateuszholik.uicomponents.bottomnavigation.BottomNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainViewModel: MainViewModel = hiltViewModel()
            val theme by mainViewModel.theme.collectAsStateWithLifecycle()

            FootballScoreTheme(
                theme = theme,
                dynamicColors = false
            ) {
                val systemUiController = rememberSystemUiController()
                val navController = rememberNavController()
                val currentBackStackState by navController.currentBackStackEntryAsState()

                val darkTheme = when (theme) {
                    Theme.SYSTEM -> isSystemInDarkTheme()
                    Theme.LIGHT -> false
                    Theme.DARK -> true
                }

                systemUiController.setStatusBarColor(
                    color = MaterialTheme.colorScheme.surface,
                    darkIcons = !darkTheme
                )

                systemUiController.setNavigationBarColor(
                    color = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp),
                    darkIcons = !darkTheme
                )

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = {
                        NavHost(
                            navController = navController,
                            startDestination = MainNavigation.ROOT
                        ) { mainNavigationGraph(navController, it) }
                    },
                    bottomBar = {
                        BottomNavigation(
                            items = BOTTOM_NAV_ITEMS,
                            onItemClick = { navController.navigateToBottomNavItem(it) },
                            currentRoute = currentBackStackState?.destination?.route
                        )
                    }
                )
            }
        }
    }
}
