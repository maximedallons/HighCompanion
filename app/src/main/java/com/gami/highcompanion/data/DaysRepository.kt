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

    fun addDay(day: DayStats) {
        daysDao?.addDay(day)
    }

    fun addSmokedJoint(smokedJoints: Double) {
        daysDao?.addSmokedJoint(smokedJoints)
    }
    fun substractSmokedJoint(smokedJoints: Double) {
        daysDao?.substractSmokedJoint(smokedJoints)
    }
    fun resetSmokedJoints(){
        daysDao?.resetSmokedJoints()
    }

    val getDayStats: LiveData<DayStats>? = daysDao?.getDay()

    val getDailySmokedJoints: LiveData<Double>? = daysDao?.getDailySmokedJoints()
    val getWeeklySmokedJoints: LiveData<Double>? = daysDao?.getWeeklySmokedJoints()
    val getMonthlySmokedJoints: LiveData<Double>? = daysDao?.getMonthlySmokedJoints()

    val getDailySpentAmount: LiveData<Double>? = daysDao?.getDailySpentAmount()
    val getWeeklySpentAmount: LiveData<Double>? = daysDao?.getWeeklySpentAmount()
    val getMonthlySpentAmount: LiveData<Double>? = daysDao?.getMonthlySpentAmount()
}