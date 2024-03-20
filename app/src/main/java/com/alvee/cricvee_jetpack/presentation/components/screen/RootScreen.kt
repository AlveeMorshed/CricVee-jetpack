package com.alvee.cricvee_jetpack.presentation.components.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alvee.cricvee_jetpack.presentation.components.screen.home.HomeScreen
import com.alvee.cricvee_jetpack.presentation.ui.theme.DarkViolet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = DarkViolet,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    ),
                    title = {
                        Text("Small Top App Bar")
                    }
                )
            },
        ) {
            Box(modifier = Modifier.padding(it)) {
                //Place NavGraph here instead of screens
                HomeScreen()
            }

        }
    }
}