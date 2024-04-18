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
        Log.d(TAG, "Job shuru korar agey")
        val fixtureList: List<FixtureData> = apiRepo.fetchTrendingFixtures(UtilTools.DURATION).data
        Log.d(TAG, "invoke: Size koto? ${fixtureList.size}")
        if(fixtureList.isNotEmpty()) {
            try {
                Log.d(TAG, "invoke: Exception khabo ki? ")
                return repo.insertAllFixtures(fixtureList)
            } catch (e: Exception) {
                Log.d(TAG, "Exception khaisi:\t ${e.message}")
            }

        }
//        return repo.insertAllFixtures(fixtureList)
    }
}