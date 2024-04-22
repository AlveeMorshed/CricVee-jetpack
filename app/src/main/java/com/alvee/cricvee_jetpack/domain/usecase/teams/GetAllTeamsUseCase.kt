package com.alvee.cricvee_jetpack.domain.usecase.teams

import com.alvee.cricvee_jetpack.data.db.model.teams.TeamData
import com.alvee.cricvee_jetpack.domain.repository.TeamRepository
import kotlinx.coroutines.flow.Flow

class GetAllTeamsUseCase(
    private val repo: TeamRepository,
) {
    operator fun invoke(): Flow<List<TeamData>> {
        return repo.getAllTeams()
    }
}