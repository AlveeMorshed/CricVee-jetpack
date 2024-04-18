package com.alvee.cricvee_jetpack.presentation.components.screen.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alvee.cricvee_jetpack.R
import com.alvee.cricvee_jetpack.presentation.components.IndeterminateCircularIndicator
import com.alvee.cricvee_jetpack.presentation.viewmodel.FixtureViewModel
import com.alvee.cricvee_jetpack.presentation.viewmodel.TeamViewModel


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    fixtureViewModel: FixtureViewModel = hiltViewModel(),
    teamViewModel: TeamViewModel = hiltViewModel(),
) {
    val fixtureState by fixtureViewModel.state.collectAsState()
    val teamsState by teamViewModel.state.collectAsState()
    var recentMatchesLoading: MutableState<Boolean> = remember { mutableStateOf(true) }
    Log.d("tag", "vai recompose hocche")
//    fixtureViewModel.fetchTrendingFixtures()
//    fixtureViewModel.showRecentMatchesFromDB()
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.home_top_title),
                modifier = Modifier.padding(top = 8.dp),
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.finishedStatusColor)
            )
            Box(
                contentAlignment = Alignment.Center
            )
            {
                LazyRow {
                    items(
                        items = fixtureState.matchList
                    ) {
                        MatchCard(
                            Modifier.fillParentMaxWidth(0.95f),
                            match = it
                        )
                        recentMatchesLoading.value = false
                    }
                }
                IndeterminateCircularIndicator(
                    loading = recentMatchesLoading,
                    modifier = Modifier.height(135.dp)
                )


            }

        }

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}