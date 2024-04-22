package com.alvee.cricvee_jetpack.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvee.cricvee_jetpack.domain.usecase.teams.TeamsUseCase
import com.alvee.cricvee_jetpack.presentation.states.TeamsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "TeamViewModel"
@HiltViewModel
class TeamViewModel @Inject constructor(
    private val teamsUseCase: TeamsUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(TeamsState())
    val state = _state.asStateFlow()
    private var teamJob: Job? = null
    private var readTeamJob: Job? = null

    init {
        try {
            fetchAllTeams()
        } catch (e: Exception) {
            Log.d(TAG, "e: ${e.message}")
        }
    }

    fun fetchAllTeams() {
        teamJob?.cancel()
        teamJob = viewModelScope.launch(Dispatchers.IO) {
            teamsUseCase.addAllTeamsUseCase()
            teamsUseCase.getAllTeamsUseCase().collect() {
                _state.value = _state.value.copy(teamsList = it)
            }
            Log.d(TAG, "fetchAllTeams: DID I DIE??")
        }
    }

    /*fun getTeamData(teamId: Int): {
        readTeamJob?.cancel()
        readTeamJob = viewModelScope.launch(Dispatchers.IO) {
            teamsUseCase.getTeamDataUseCase(teamId)
        }
    }*/
}