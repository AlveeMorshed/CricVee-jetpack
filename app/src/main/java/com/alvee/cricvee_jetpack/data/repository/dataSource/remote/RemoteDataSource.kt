package com.alvee.cricvee_jetpack.data.repository.dataSource.remote

import com.moinul.cricvee.model.fixtures.AllFixtures

interface RemoteDataSource {
    suspend fun fetchTrendingFixtures(duration: String):AllFixtures
}