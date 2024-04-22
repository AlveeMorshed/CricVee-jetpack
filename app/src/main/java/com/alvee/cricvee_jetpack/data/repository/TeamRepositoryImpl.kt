package com.alvee.cricvee_jetpack.data.repository

import com.alvee.cricvee_jetpack.data.db.dao.TeamDao
import com.alvee.cricvee_jetpack.data.db.model.teams.TeamData
import com.alvee.cricvee_jetpack.domain.repository.TeamRepository
import kotlinx.coroutines.flow.Flow

class TeamRepositoryImpl(private val dao: TeamDao) : TeamRepository {
    override suspend fun insertAllTeams(teamList: List<TeamData>) {
        return dao.insertAllTeams(teamList)
    }

    override fun getAllTeams(): Flow<List<TeamData>> {
        return dao.getAllTeams()
    }


}