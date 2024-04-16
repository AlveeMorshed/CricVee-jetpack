package com.alvee.cricvee_jetpack.presentation.components.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TeamCard()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = fixtureData.round.toString(),
            )
            Row {
                TeamScore()
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.vs),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 2.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                TeamScore()
            }
        }
        TeamCard()
    }
}