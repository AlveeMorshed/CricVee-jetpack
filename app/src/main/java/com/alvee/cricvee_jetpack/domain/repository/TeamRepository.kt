package com.alvee.cricvee_jetpack.domain.repository

import com.alvee.cricvee_jetpack.data.db.model.teams.TeamData

interface TeamRepository {
    suspend fun insertAllTeams(teamList: List<TeamData>)
    
}
