//package com.alvee.cricvee_jetpack.di
//
//import com.alvee.cricvee_jetpack.data.db.LocalDatabase
//import com.alvee.cricvee_jetpack.data.repository.FixtureRepositoryImpl
//import com.alvee.cricvee_jetpack.domain.repository.FixtureRepository
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object RepositoryModule {
//    @Provides
//    @Singleton
//    fun provideFixtureRepository(db: LocalDatabase): FixtureRepository{
//        return FixtureRepositoryImpl(db.fixtureDao)
//    }
//}