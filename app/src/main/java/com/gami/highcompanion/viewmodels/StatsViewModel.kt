package com.gami.highcompanion.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import com.gami.highcompanion.data.DaysRepository
import com.gami.highcompanion.models.DayStats
import kotlinx.coroutines.launch

class StatsViewModel : ViewModel() {

    private val repository: DaysRepository = DaysRepository.getInstance()

    fun getDailySmokedJoints(): LiveData<Double>? {
        return repository.getDailySmokedJoints
    }
    fun getWeeklySmokedJoints(): LiveData<Double>? {
        return repository.getWeeklySmokedJoints
    }
    fun getMonthlySmokedJoints(): LiveData<Double>? {
        return repository.getMonthlySmokedJoints
    }

    fun getDailySpentAmount(): LiveData<Double>? {
        return repository.getDailySpentAmount
    }
    fun getWeeklySpentAmount(): LiveData<Double>? {
        return repository.getWeeklySpentAmount
    }
    fun getMonthlySpentAmount(): LiveData<Double>? {
        return repository.getMonthlySpentAmount
    }
}