package com.alvee.cricvee_jetpack.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvee.cricvee_jetpack.domain.usecase.fixtures.FixtureUseCase
import com.alvee.cricvee_jetpack.presentation.states.FixtureState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "FixtureViewModel"
@HiltViewModel
class FixtureViewModel @Inject constructor(
    private val fixtureUseCase: FixtureUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(FixtureState())
    val state = _state.asStateFlow()

//    private val _recentResultsState = SnapshotStateList<MatchState>()
//    val recentResultsState = _recentResultsState.as

    private var fixtureInsertionJob: Job? = null
    private var fixtureReadJob: Job? = null

    init {
        try {
            fetchTrendingFixtures()
            showRecentMatchesFromDB()
        } catch (e: Exception) {
            Log.d(TAG, "Init block: ${e.message}")
        }

    }

    fun fetchTrendingFixtures() {
        Log.d(TAG, "fetchTrendingFixtures: Fetch started")
        fixtureInsertionJob?.cancel()
        fixtureInsertionJob = viewModelScope.launch(Dispatchers.IO) {
            fixtureUseCase.addFixturesUseCase()
        }
    }
    fun showRecentMatchesFromDB() {
        Log.d(TAG, "showRecentMatchesFromDB: Retrieve from DB started")
        fixtureReadJob?.cancel()
        fixtureReadJob = viewModelScope.launch(Dispatchers.IO) {
            fixtureUseCase.getRecentMatchesUseCase().collect {
                for (match in it) {
                    try {
                        val matchResult = fixtureUseCase.getFixtureRunsUseCase(match.id)
                        match.runs = matchResult.data.runs
                    } catch (e: Exception) {
                        Log.d(TAG, "showRecentMatchesFromDB: ${e.message}")
                    }
                }
                _state.value = _state.value.copy(matchList = it)
                Log.d(TAG, "showRecentMatchesFromDB: AM I WORKING???")
            }
        }
        Log.d(TAG, "showRecentMatchesFromDB: " + state.value.matchList.size)
    }

//    suspend fun fetchRunsByFixtureId(fixtureId: Int): FixtureWithRun {
//        val matchState = MutableStateFlow(MatchState())
//        fixtureReadJob?.cancel()
//        fixtureReadJob = viewModelScope.launch(Dispatchers.IO) {
////            fixtureUseCase.getFixtureRunsUseCase(fixtureId).collect{
////                matchState.value = matchState.value.copy(fixtureWithRun = it)
////            }
//        }
//        return matchState
//    }


}