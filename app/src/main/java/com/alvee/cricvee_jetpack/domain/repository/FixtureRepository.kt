package com.alvee.cricvee_jetpack.domain.repository

import com.alvee.cricvee_jetpack.data.db.model.teams.TeamData
import com.moinul.cricvee.model.fixtures.FixtureData
import kotlinx.coroutines.flow.Flow

interface FixtureRepository {

    suspend fun insertAllFixtures(fixtureList: List<FixtureData>)
    suspend fun insertAllTeams(teamsList: List<TeamData>)

    fun readRecentFixtureData(): Flow<List<FixtureData>>
}