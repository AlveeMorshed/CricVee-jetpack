package com.alvee.cricvee_jetpack.presentation.components.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alvee.cricvee_jetpack.R
import com.alvee.cricvee_jetpack.domain.utils.Constants
import com.alvee.cricvee_jetpack.presentation.ui.theme.DarkViolet
import com.moinul.cricvee.model.fixtures.FixtureData

@Composable
fun MatchCard(
    modifier: Modifier = Modifier,
    match: FixtureData,
) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(corner = CornerSize(14.dp)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = Modifier
                    .size(19.dp),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = stringResource(R.string.league_image)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(R.string.demo_string),
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.finishedStatusColor),
                textAlign = TextAlign.Center
            )
        }

        MatchScores(
            fixtureData = match
        )

        Text(
            text = match.starting_at.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            textAlign = TextAlign.Center
        )

        Text(
            text = if (match.status != Constants.NOT_STARTED) {
                match.note.toString()
            } else {
                Constants.YET_TO_START
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(DarkViolet)
                .padding(4.dp),
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}