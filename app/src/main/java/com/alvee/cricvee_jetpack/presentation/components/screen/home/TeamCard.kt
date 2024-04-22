package com.alvee.cricvee_jetpack.presentation.components.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alvee.cricvee_jetpack.data.db.model.teams.TeamData
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TeamCard(
    modifier: Modifier = Modifier,
    teamData: TeamData?,
    onLoadingComplete: (Boolean) -> Unit,
) {

    Box(
        modifier = Modifier,
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = modifier
                .padding(horizontal = 8.dp)
                .width(89.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ElevatedCard(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(65.dp),
                shape = RoundedCornerShape(7.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                GlideImage(
                    model = teamData?.image_path.toString(),
                    contentDescription = "Team Image",
                    modifier = Modifier
                        .padding(8.dp)/*.clickable(onClick = onClick)*/
                        .fillMaxSize(),
                )
                /*Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = stringResource(R.string.team_1_image),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                )*/
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = teamData?.code ?: "",
                modifier = Modifier
                    .fillMaxWidth(),
                fontSize = 13.75.sp,
                textAlign = TextAlign.Center
            )
            onLoadingComplete(false)

        }
    }
}