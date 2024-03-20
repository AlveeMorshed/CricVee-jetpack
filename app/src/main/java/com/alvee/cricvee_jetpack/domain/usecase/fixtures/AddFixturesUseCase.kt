package com.alvee.cricvee_jetpack.domain.usecase.fixtures

import com.alvee.cricvee_jetpack.domain.repository.FixtureRepository
import com.alvee.cricvee_jetpack.domain.repository.remote.ApiRepository
import com.alvee.cricvee_jetpack.domain.utils.UtilTools
import com.moinul.cricvee.model.fixtures.FixtureData

class AddFixturesUseCase(
    private val apiRepo: ApiRepository,
    private val repo: FixtureRepository
) {
    suspend operator fun invoke() {
        val fixtureList: List<FixtureData> = apiRepo.fetchTrendingFixtures(UtilTools.DURATION).data
        if(fixtureList.isNotEmpty()){
            return repo.insertAllFixtures(fixtureList)
        }
//        return repo.insertAllFixtures(fixtureList)
    }
}