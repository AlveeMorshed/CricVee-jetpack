package com.alvee.cricvee_jetpack.data.repository.dataSource.remote

import com.alvee.cricvee_jetpack.data.db.model.teams.AllTeams
import com.moinul.cricvee.model.fixtures.AllFixtures

interface RemoteDataSource {
    suspend fun fetchTrendingFixtures(duration: String): AllFixtures
    suspend fun fetchAllTeams(): AllTeams
}