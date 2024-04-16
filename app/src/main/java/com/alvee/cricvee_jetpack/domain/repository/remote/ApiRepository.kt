package com.alvee.cricvee_jetpack.domain.repository.remote

import com.alvee.cricvee_jetpack.data.db.model.teams.AllTeams
import com.moinul.cricvee.model.fixtures.AllFixtures

interface ApiRepository {

    suspend fun fetchTrendingFixtures(duration: String): AllFixtures
    suspend fun fetchAllTeams(): AllTeams

}