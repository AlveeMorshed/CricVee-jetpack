package com.alvee.cricvee_jetpack.presentation.components.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TeamScore(
    modifier: Modifier = Modifier,
    score: Int?,
    wickets: Int?,
    overs: Double?,
) {
    Column(
        modifier = modifier.padding(bottom = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$score/$wickets",
        )
        Text(
            text = "($overs)",
            fontSize = 13.75.sp
        )
    }
}