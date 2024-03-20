package com.alvee.cricvee_jetpack.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alvee.cricvee_jetpack.data.db.dao.FixtureDao
import com.alvee.cricvee_jetpack.domain.utils.Constants
import com.moinul.cricvee.model.fixtures.FixtureData

@Database(
    entities = [FixtureData::class],
    version = 1,
    exportSchema = false
)
abstract class LocalDatabase : RoomDatabase() {
    abstract val fixtureDao: FixtureDao

    companion object{
        @Volatile
        private var databaseInstance: LocalDatabase? = null

        fun getDatabase(context: Context): LocalDatabase{
            return databaseInstance ?: synchronized(this){
                Room.databaseBuilder(
                    context, LocalDatabase::class.java, Constants.DATABASE_NAME
                ).fallbackToDestructiveMigration()
                    .build()
                    .also { databaseInstance = it }
            }
        }
    }
}