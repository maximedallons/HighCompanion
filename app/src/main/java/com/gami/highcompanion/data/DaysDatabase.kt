package com.gami.highcompanion.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gami.highcompanion.models.DayStats
import java.lang.IllegalStateException

@Database(entities = [DayStats::class], version = 1, exportSchema = false)
@TypeConverters(DataConverters::class)
abstract class DaysDatabase : RoomDatabase() {

    abstract fun daysDao(): DaysDAO

    companion object {
        private var INSTANCE: DaysDatabase? = null;

        fun getDatabase(context: Context): DaysDatabase? {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DaysDatabase::class.java,
                    "days_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

        fun getInstance(): DaysDatabase?{
            if(INSTANCE == null){
                throw IllegalStateException("Database must be initialized")
            }
            return INSTANCE
        }

        fun disconnectDatabase() {
            INSTANCE = null
        }
    }

}