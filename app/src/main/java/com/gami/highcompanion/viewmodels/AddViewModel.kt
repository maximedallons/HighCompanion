package com.gami.highcompanion.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gami.highcompanion.data.DaysRepository
import com.gami.highcompanion.models.DayStats
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel : ViewModel() {

    private val repository: DaysRepository = DaysRepository.getInstance()

    fun addDay(day: DayStats) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addDay(day)
        }
    }

    fun addSmokedJoint(smokedJoints: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSmokedJoint(smokedJoints)
        }
    }
    fun substractSmokedJoint(smokedJoints: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.substractSmokedJoint(smokedJoints)
        }
    }
    fun resetSmokedJoints() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.resetSmokedJoints()
        }
    }

    fun getDailySmokedJoints(): LiveData<Double>? {
        return repository.getDailySmokedJoints
    }

    fun getDayStats(): LiveData<DayStats>? {
        return repository.getDayStats
    }
}