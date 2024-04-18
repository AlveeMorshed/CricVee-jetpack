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

    private var fixtureInsertionJob: Job? = null
    private var fixtureReadJob: Job? = null

    init {
        try {
            fetchTrendingFixtures()
            showRecentMatchesFromDB()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
    fun fetchTrendingFixtures() {
        Log.d(TAG, "fetchTrendingFixtures: Fetch started")
        fixtureInsertionJob?.cancel()
        fixtureInsertionJob = viewModelScope.launch(Dispatchers.IO) {
            try {
                fixtureUseCase.addFixturesUseCase()

            } catch (e: Exception) {
                Log.d(TAG, "fetchTrendingFixtures: Exception khaisi \t ${e.message}")
            }
        }
        Log.d(TAG, "fetchTrendingFixtures: Fetch successful")
    }

    private fun showRecentMatchesFromDB() {
        Log.d(TAG, "showRecentMatchesFromDB: Retrieve from DB started")
        fixtureReadJob?.cancel()
        fixtureReadJob = viewModelScope.launch(Dispatchers.IO) {
            fixtureUseCase.getRecentMatchesUseCase().collect {
                _state.value = _state.value.copy(matchList = it)
            }
        }
        Log.d(TAG, "showRecentMatchesFromDB: Retrieve from DB successful")
    }
}