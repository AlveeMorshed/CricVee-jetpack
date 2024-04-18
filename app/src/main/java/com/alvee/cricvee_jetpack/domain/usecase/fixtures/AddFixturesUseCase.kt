package com.alvee.cricvee_jetpack.domain.usecase.fixtures

import android.util.Log
import com.alvee.cricvee_jetpack.domain.repository.FixtureRepository
import com.alvee.cricvee_jetpack.domain.repository.remote.ApiRepository
import com.alvee.cricvee_jetpack.domain.utils.UtilTools
import com.moinul.cricvee.model.fixtures.FixtureData

private const val TAG = "AddFixturesUseCase"
class AddFixturesUseCase(
    private val apiRepo: ApiRepository,
    private val repo: FixtureRepository
) {
    suspend operator fun invoke() {
        val fixtureList: List<FixtureData> = apiRepo.fetchTrendingFixtures(UtilTools.DURATION).data
        Log.d(TAG, "invoke: " + fixtureList.size)
        if(fixtureList.isNotEmpty()){
            Log.d(TAG, "invoke: insertion happening")
            return repo.insertAllFixtures(fixtureList)
        }
    }
}