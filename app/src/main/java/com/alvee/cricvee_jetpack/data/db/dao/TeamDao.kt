package com.alvee.cricvee_jetpack.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.alvee.cricvee_jetpack.data.db.model.teams.TeamData

@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllTeams(teamList: List<TeamData>)
}