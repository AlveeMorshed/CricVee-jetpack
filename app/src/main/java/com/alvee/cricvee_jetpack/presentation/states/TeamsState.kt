package com.alvee.cricvee_jetpack.presentation.states

import com.alvee.cricvee_jetpack.data.db.model.teams.TeamData

data class TeamsState(
    val teamsList: List<TeamData> = emptyList(),
)
