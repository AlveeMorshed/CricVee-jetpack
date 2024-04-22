package com.alvee.cricvee_jetpack.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.moinul.cricvee.model.fixtures.FixtureData
import com.moinul.cricvee.model.fixtures.FixtureRunData
import kotlinx.coroutines.flow.Flow

@Dao
interface FixtureDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFixtures(fixtureList: List<FixtureData>)

    @Query("select * from fixture_table where not status='NS' order by starting_at desc limit 7")
    fun readRecentFixtureData(): Flow<List<FixtureRunData>>
}