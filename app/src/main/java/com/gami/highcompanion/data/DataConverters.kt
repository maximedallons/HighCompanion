package com.gami.highcompanion.data

import androidx.room.TypeConverter
import java.util.*

class DataConverters {
    @TypeConverter
    fun fromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun toDate(date: Long): Date {
        return Date(date)
    }
}