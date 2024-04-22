package com.alvee.cricvee_jetpack.domain.repository

import com.alvee.cricvee_jetpack.data.db.model.teams.TeamData
import kotlinx.coroutines.flow.Flow

interface TeamRepository {
    suspend fun insertAllTeams(teamList: List<TeamData>)
    fun getAllTeams(): Flow<List<TeamData>>
}
