package com.gami.highcompanion.data

import androidx.lifecycle.LiveData
import com.gami.highcompanion.models.DayStats

class DaysRepository {
    companion object{
        private var instance : DaysRepository? = null;

        fun getInstance(): DaysRepository{
            if(instance == null){
                instance = DaysRepository()
            }
            return instance as DaysRepository
        }
    }
    private val daysDao = DaysDatabase.getInstance()?.daysDao()

    fun addCollection(day: DayStats) {
        daysDao?.addDay(day)
    }

    fun updateCollection(day: DayStats) {
        daysDao?.updateDay(day)
    }

    val getDailySmokedJoints: LiveData<Int>? = daysDao?.getDailySmokedJoints()
    val getWeeklySmokedJoints: LiveData<Int>? = daysDao?.getWeeklySmokedJoints()
    val getMonthlySmokedJoints: LiveData<Int>? = daysDao?.getMonthlySmokedJoints()

    val getDailySpentAmount: LiveData<Double>? = daysDao?.getDailySpentAmount()
    val getWeeklySpentAmount: LiveData<Double>? = daysDao?.getWeeklySpentAmount()
    val getMonthlySpentAmount: LiveData<Double>? = daysDao?.getMonthlySpentAmount()
}