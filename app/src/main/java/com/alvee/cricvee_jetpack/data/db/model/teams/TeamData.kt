package com.alvee.cricvee_jetpack.data.db.model.teams

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team_table")
data class TeamData(
    val code: String?,
    val country_id: Int?,
    @PrimaryKey val id: Int,
    val image_path: String?,
    val name: String?,
    val national_team: Boolean?,
    val resource: String?,
    val updated_at: String?,
) {
    constructor() : this(
        null, null, 0, null, null, null, null, null
    )
}