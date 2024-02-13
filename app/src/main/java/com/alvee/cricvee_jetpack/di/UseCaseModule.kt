//package com.alvee.cricvee_jetpack.di
//
//import com.alvee.cricvee_jetpack.domain.repository.FixtureRepository
//import com.alvee.cricvee_jetpack.domain.usecase.fixtures.FixtureUseCase
//import com.alvee.cricvee_jetpack.domain.usecase.fixtures.GetRecentMatchesUseCase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//@Module
//@InstallIn(SingletonComponent::class)
//object UseCaseModule {
//    @Provides
//    @Singleton
//    fun provideFixtureUseCase(repo: FixtureRepository): FixtureUseCase {
//        return FixtureUseCase(
//            getRecentMatchesUseCase = GetRecentMatchesUseCase(repo)
//        )
//    }
//}