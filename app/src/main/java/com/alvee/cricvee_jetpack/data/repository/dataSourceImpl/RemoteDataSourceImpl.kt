package com.alvee.cricvee_jetpack.data.repository.dataSourceImpl

import com.alvee.cricvee_jetpack.data.db.api.SportsApiService
import com.alvee.cricvee_jetpack.data.db.model.teams.AllTeams
import com.alvee.cricvee_jetpack.data.repository.dataSource.remote.RemoteDataSource
import com.moinul.cricvee.model.fixtures.AllFixtures

class RemoteDataSourceImpl(private val apiService: SportsApiService) :RemoteDataSource {
    override suspend fun fetchTrendingFixtures(duration: String): AllFixtures {
        return apiService.fetchTrendingFixtures(duration)
    }

    override suspend fun fetchAllTeams(): AllTeams {
        return apiService.fetchAllTeams()
    }
}