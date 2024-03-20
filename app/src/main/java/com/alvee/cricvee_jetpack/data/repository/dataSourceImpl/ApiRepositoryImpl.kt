package com.alvee.cricvee_jetpack.data.repository.dataSourceImpl

import com.alvee.cricvee_jetpack.data.repository.dataSource.remote.RemoteDataSource
import com.alvee.cricvee_jetpack.domain.repository.remote.ApiRepository
import com.moinul.cricvee.model.fixtures.AllFixtures

class ApiRepositoryImpl(private val remoteDataSource: RemoteDataSource) :ApiRepository {
    override suspend fun fetchTrendingFixtures(duration: String): AllFixtures {
        return remoteDataSource.fetchTrendingFixtures(duration)
    }
}