package com.alvee.cricvee_jetpack.di

import com.alvee.cricvee_jetpack.data.db.LocalDatabase
import com.alvee.cricvee_jetpack.data.db.api.SportsApiService
import com.alvee.cricvee_jetpack.data.repository.FixtureRepositoryImpl
import com.alvee.cricvee_jetpack.data.repository.TeamRepositoryImpl
import com.alvee.cricvee_jetpack.data.repository.dataSource.remote.RemoteDataSource
import com.alvee.cricvee_jetpack.data.repository.dataSourceImpl.ApiRepositoryImpl
import com.alvee.cricvee_jetpack.data.repository.dataSourceImpl.RemoteDataSourceImpl
import com.alvee.cricvee_jetpack.domain.repository.FixtureRepository
import com.alvee.cricvee_jetpack.domain.repository.TeamRepository
import com.alvee.cricvee_jetpack.domain.repository.remote.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideFixtureRepository(db: LocalDatabase): FixtureRepository {
        return FixtureRepositoryImpl(db.fixtureDao)
    }

    @Provides
    @Singleton
    fun provideTeamRepository(db: LocalDatabase): TeamRepository {
        return TeamRepositoryImpl(db.teamDao)
    }

    @Provides
    @Singleton
    fun provideApiRepository(remoteDataSource: RemoteDataSource): ApiRepository {
        return ApiRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(apiService: SportsApiService): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }


}