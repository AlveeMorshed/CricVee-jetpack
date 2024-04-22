package com.alvee.cricvee_jetpack.domain.usecase.fixtures

import com.alvee.cricvee_jetpack.domain.repository.FixtureRepository
import com.moinul.cricvee.model.fixtures.FixtureRunData
import kotlinx.coroutines.flow.Flow

class GetRecentMatchesUseCase(
    private val repo: FixtureRepository
) {
    operator fun invoke(): Flow<List<FixtureRunData>> {
        return repo.readRecentFixtureData()
    }
}
