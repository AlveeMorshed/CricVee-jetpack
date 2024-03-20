package com.alvee.cricvee_jetpack.data.repository

import com.alvee.cricvee_jetpack.data.db.dao.FixtureDao
import com.alvee.cricvee_jetpack.domain.repository.FixtureRepository
import com.moinul.cricvee.model.fixtures.FixtureData
import kotlinx.coroutines.flow.Flow

class FixtureRepositoryImpl(private val dao: FixtureDao) : FixtureRepository {

    override suspend fun insertAllFixtures(fixtureList: List<FixtureData>) {
        dao.insertAllFixtures(fixtureList)
    }

    override fun readRecentFixtureData(): Flow<List<FixtureData>> {
        return dao.readRecentFixtureData()
    }

}