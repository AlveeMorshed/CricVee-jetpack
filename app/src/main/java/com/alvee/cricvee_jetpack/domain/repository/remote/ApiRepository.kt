package com.alvee.cricvee_jetpack.domain.repository.remote

import com.moinul.cricvee.model.fixtures.AllFixtures

interface ApiRepository {

    suspend fun fetchTrendingFixtures(duration: String): AllFixtures

}