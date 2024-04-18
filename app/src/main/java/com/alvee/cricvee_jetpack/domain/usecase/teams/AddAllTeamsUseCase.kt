package com.alvee.cricvee_jetpack.domain.usecase.teams

import com.alvee.cricvee_jetpack.data.db.model.teams.TeamData
import com.alvee.cricvee_jetpack.domain.repository.TeamRepository
import com.alvee.cricvee_jetpack.domain.repository.remote.ApiRepository

class AddAllTeamsUseCase(
    private val apiRepo: ApiRepository,
    private val repo: TeamRepository,
) {
    suspend operator fun invoke() {
        val teamList: List<TeamData> = apiRepo.fetchAllTeams().data
        if (teamList.isNotEmpty()) {
            return repo.insertAllTeams(teamList)
        }
    }
}
