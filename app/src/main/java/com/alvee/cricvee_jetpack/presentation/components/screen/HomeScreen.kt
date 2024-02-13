package com.alvee.cricvee_jetpack.presentation.components.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
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
//import androidx.hilt.navigation.compose.hiltViewModel
import com.alvee.cricvee_jetpack.R


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
    //fixtureViewModel: FixtureViewModel = hiltViewModel()
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.home_top_title),
                modifier = Modifier.padding(top = 8.dp),
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.finishedStatusColor)
            )
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults
                    .cardElevation(defaultElevation = 8.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(corner = CornerSize(14.dp))
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
                        contentDescription = "league image"
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = stringResource(R.string.home_top_title),
                        modifier = Modifier,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.finishedStatusColor),
                        textAlign = TextAlign.Center
                    )
                }
                ElevatedCard(
                    modifier = Modifier
                        .size(65.dp)
                        .padding(start = 16.dp, top = 8.dp),
                    shape = RoundedCornerShape(7.dp),
                    elevation = CardDefaults.cardElevation(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "team 1 image",
                        modifier = modifier
                            .padding(8.dp)
                    )
                }

            }
        }

    }
}