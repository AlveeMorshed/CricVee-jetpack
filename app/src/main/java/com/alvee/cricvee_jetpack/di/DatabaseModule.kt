package com.alvee.cricvee_jetpack.di

import android.app.Application
import com.alvee.cricvee_jetpack.data.db.LocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application): LocalDatabase {
        return LocalDatabase.getDatabase(app)
    }
}