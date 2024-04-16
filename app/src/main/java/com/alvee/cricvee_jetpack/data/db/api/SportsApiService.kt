package com.alvee.cricvee_jetpack.data.db.api

import com.alvee.cricvee_jetpack.data.db.model.teams.AllTeams
import com.moinul.cricvee.model.fixtures.AllFixtures
import com.moinul.cricvee.model.fixtures.FixtureWithRun
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface SportsApiService {
    @GET(ApiConstants.FIXTURE_ENDPOINT)
    suspend fun fetchTrendingFixtures(
        @Query("filter[starts_between]") duration: String,
        @Query("api_token") api_token: String = ApiConstants.API_KEY,
    ): AllFixtures

    @GET(ApiConstants.TEAM_ENDPOINT)
    suspend fun fetchAllTeams(@Query("api_token") api_token: String = ApiConstants.API_KEY): AllTeams

    @GET(ApiConstants.FIXTURE_ENDPOINT + "/{fixtureId}")
    suspend fun fetchRunsByFixtureId(
        @Path("fixtureId") fixtureId: Int,
        @Query("include") includeParam: String = "runs",
        @Query("api_token") api_token: String = ApiConstants.API_KEY,
    ): FixtureWithRun

}