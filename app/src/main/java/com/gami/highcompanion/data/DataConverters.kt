package com.gami.highcompanion.data

import androidx.room.TypeConverter
import java.time.LocalDate

class DataConverters {
    @TypeConverter
    fun fromDate(date: LocalDate): String? {
        if (date.equals(null)){
            return null;
        }
        return date.toString()
    }

    @TypeConverter
    fun toDate(timestamp: String): LocalDate? {
        val ldt: LocalDate;
        if (timestamp == null){
            return null;
        }else{
            ldt = LocalDate.parse(timestamp)
        }
        return ldt
    }
}