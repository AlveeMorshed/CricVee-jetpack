package com.alvee.cricvee_jetpack.data.db.api

import com.moinul.cricvee.model.fixtures.AllFixtures
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query




interface SportsApiService {
    @GET(ApiConstants.FIXTURE_ENDPOINT)
    suspend fun fetchTrendingFixtures(
        @Query("filter[starts_between]") duration: String,
        @Query("api_token") api_token: String = ApiConstants.API_KEY
    ): AllFixtures
}