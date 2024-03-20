package com.alvee.cricvee_jetpack.di

import com.alvee.cricvee_jetpack.data.db.api.ApiConstants
import com.alvee.cricvee_jetpack.data.db.api.SportsApiService
import com.alvee.cricvee_jetpack.domain.repository.FixtureRepository
import com.alvee.cricvee_jetpack.domain.repository.remote.ApiRepository
import com.alvee.cricvee_jetpack.domain.usecase.fixtures.AddFixturesUseCase
import com.alvee.cricvee_jetpack.domain.usecase.fixtures.FixtureUseCase
import com.alvee.cricvee_jetpack.domain.usecase.fixtures.GetRecentMatchesUseCase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideFixtureUseCase(
        repo: FixtureRepository,
        apiRepo:ApiRepository
    ): FixtureUseCase {
        return FixtureUseCase(
            addFixturesUseCase = AddFixturesUseCase(repo = repo, apiRepo = apiRepo),
            getRecentMatchesUseCase = GetRecentMatchesUseCase(repo),
        )
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(ApiConstants.BASE_URL).build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): SportsApiService{
        return retrofit.create(SportsApiService::class.java)
    }
}