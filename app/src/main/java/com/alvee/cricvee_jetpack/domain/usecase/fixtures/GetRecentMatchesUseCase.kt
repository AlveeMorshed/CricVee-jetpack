package com.alvee.cricvee_jetpack.domain.usecase.fixtures

import com.alvee.cricvee_jetpack.domain.repository.FixtureRepository
import com.moinul.cricvee.model.fixtures.FixtureData
import kotlinx.coroutines.flow.Flow

class GetRecentMatchesUseCase(private val repo: FixtureRepository) {
    suspend operator fun invoke(): Flow<List<FixtureData>> {
        return repo.readRecentFixtureData()
    }
}
