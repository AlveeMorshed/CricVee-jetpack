package com.alvee.cricvee_jetpack.presentation.viewmodel

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

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val teamsUseCase: TeamsUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(TeamsState())
    val state = _state.asStateFlow()
    private var teamJob: Job? = null
    /*init {
        try {
            fetchAllTeams()
        }catch (e: Exception){
            e.printStackTrace()
        }
    }*/

    fun fetchAllTeams() {
        teamJob?.cancel()
        teamJob = viewModelScope.launch(Dispatchers.IO) {
            //teamsUseCase.addAllTeamsUseCase()
        }
    }
}