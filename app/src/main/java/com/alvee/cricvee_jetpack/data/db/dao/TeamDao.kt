package com.alvee.cricvee_jetpack.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alvee.cricvee_jetpack.data.db.model.teams.TeamData
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllTeams(teamList: List<TeamData>)

    @Query("select * from team_table")
    fun getAllTeams(): Flow<List<TeamData>>
}