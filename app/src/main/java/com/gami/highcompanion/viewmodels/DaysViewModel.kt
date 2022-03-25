package com.gami.highcompanion.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import com.gami.highcompanion.data.DaysRepository
import com.gami.highcompanion.models.DayStats
import kotlinx.coroutines.launch

class DaysViewModel : ViewModel() {

    private val repository: DaysRepository = DaysRepository.getInstance()

    fun addDay(day: DayStats) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCollection(day)
        }
    }

    fun updateCollection(day: DayStats) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCollection(day)
        }
    }

    fun getDailySmokedJoints(): LiveData<Int>? {
        return repository.getDailySmokedJoints
    }
    fun getWeeklySmokedJoints(): LiveData<Int>? {
        return repository.getWeeklySmokedJoints
    }
    fun getMonthlySmokedJoints(): LiveData<Int>? {
        return repository.getMonthlySmokedJoints
    }

    fun getDailySpentAmount(): LiveData<Float>? {
        return repository.getDailySpentAmount
    }
    fun getWeeklySpentAmount(): LiveData<Float>? {
        return repository.getWeeklySpentAmount
    }
    fun getMonthlySpentAmount(): LiveData<Float>? {
        return repository.getMonthlySpentAmount
    }
}