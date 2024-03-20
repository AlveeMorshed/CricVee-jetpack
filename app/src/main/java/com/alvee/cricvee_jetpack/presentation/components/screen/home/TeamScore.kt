package com.alvee.cricvee_jetpack.presentation.components.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.alvee.cricvee_jetpack.R

@Composable
fun TeamScore(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(bottom = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.demo_string),
        )
        Text(
            text = stringResource(id = R.string.demo_string),
        )
    }
}