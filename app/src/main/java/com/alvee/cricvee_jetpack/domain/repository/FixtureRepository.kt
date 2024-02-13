package com.alvee.cricvee_jetpack.domain.repository

import com.moinul.cricvee.model.fixtures.FixtureData
import kotlinx.coroutines.flow.Flow

interface FixtureRepository {

    suspend fun insertAllFixtures(fixtureList: List<FixtureData>)

    fun readRecentFixtureData(): Flow<List<FixtureData>>
}