package com.alvee.cricvee_jetpack.domain.usecase.fixtures

import com.alvee.cricvee_jetpack.domain.repository.remote.ApiRepository
import com.moinul.cricvee.model.fixtures.FixtureWithRun

class GetFixtureRunsUseCase(
    private val apiRepo: ApiRepository,
) {
    suspend operator fun invoke(fixtureId: Int): FixtureWithRun {
        return apiRepo.fetchRunsByFixtureId(fixtureId)
    }
}