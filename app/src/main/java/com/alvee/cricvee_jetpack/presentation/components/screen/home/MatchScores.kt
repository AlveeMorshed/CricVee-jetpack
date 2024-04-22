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
import com.alvee.cricvee_jetpack.data.db.model.teams.TeamData
import com.moinul.cricvee.model.fixtures.FixtureRunData

@Composable
fun MatchScores(
    modifier: Modifier = Modifier,
    fixtureRunData: FixtureRunData,
    localTeamData: TeamData?,
    visitorTeamData: TeamData?,
    onLoadingComplete: (Boolean) -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TeamCard(
            teamData = localTeamData,
            onLoadingComplete = onLoadingComplete
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = fixtureRunData.round.toString(),
            )
            Row {
                val localTeamResult =
                    fixtureRunData.runs?.filter { it.team_id == fixtureRunData.localteam_id }
                        ?.get(0)
                val visitorTeamResult =
                    fixtureRunData.runs?.filter { it.team_id == fixtureRunData.visitorteam_id }
                        ?.get(0)
                TeamScore(
                    score = localTeamResult?.score,
                    wickets = localTeamResult?.wickets,
                    overs = localTeamResult?.overs
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.vs),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                TeamScore(
                    score = visitorTeamResult?.score,
                    wickets = visitorTeamResult?.wickets,
                    overs = visitorTeamResult?.overs
                )
            }
        }
        TeamCard(
            teamData = visitorTeamData,
            onLoadingComplete = onLoadingComplete
        )
    }

}