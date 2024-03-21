package com.alvee.cricvee_jetpack.presentation.components.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.alvee.cricvee_jetpack.R
import com.moinul.cricvee.model.fixtures.FixtureData

@Composable
fun MatchScores(
    modifier: Modifier = Modifier,
    fixtureData: FixtureData,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TeamCard()
        TeamScore()
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 36.dp)
        ) {
            Text(
                text = stringResource(id = R.string.demo_string),
            )
            Text(
                text = stringResource(R.string.vs),
                fontWeight = FontWeight.Bold
            )
        }
        TeamScore()
        TeamCard()
    }
}