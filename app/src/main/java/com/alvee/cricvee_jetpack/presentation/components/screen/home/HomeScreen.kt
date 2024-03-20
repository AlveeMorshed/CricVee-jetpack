package com.alvee.cricvee_jetpack.presentation.components.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alvee.cricvee_jetpack.R
import com.alvee.cricvee_jetpack.presentation.viewmodel.FixtureViewModel


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: FixtureViewModel = hiltViewModel(),
) {

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.home_top_title),
                modifier = Modifier.padding(top = 8.dp),
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.finishedStatusColor)
            )

            LazyRow {
                items(count = 7){

                    MatchCard(Modifier.fillParentMaxWidth(0.94f))

                }
            }

        }

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}