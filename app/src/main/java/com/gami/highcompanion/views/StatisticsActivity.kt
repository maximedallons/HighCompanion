package com.gami.highcompanion.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.gami.highcompanion.R
import com.gami.highcompanion.databinding.ActivityStatisticsBinding
import com.gami.highcompanion.viewmodels.DaysViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class StatisticsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStatisticsBinding
    private lateinit var daysViewModel: DaysViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatisticsBinding.inflate(layoutInflater)
        daysViewModel = ViewModelProvider(this).get(DaysViewModel::class.java)
        val view = binding.root

        setContentView(view)
        initViewAttributes()
        navigationHandler()
        rangeSelectorHandler()
    }

    private fun initViewAttributes(){
        binding.btnDay.isSelected = true
        daysViewModel.getMonthlySmokedJoints()?.observe(this@StatisticsActivity) {
                smokedJoints -> binding.test.text = smokedJoints.toString()
        }
    }

    private fun rangeSelectorHandler(){
        binding.btnDay.setOnClickListener {
            binding.btnDay.isSelected = true
            binding.btnWeek.isSelected = false
            binding.btnMonth.isSelected = false
            daysViewModel.getDailySmokedJoints()?.observe(this@StatisticsActivity) {
                    smokedJoints -> binding.test.text = smokedJoints.toString()
            }
        }
        binding.btnWeek.setOnClickListener {
            binding.btnDay.isSelected = false
            binding.btnWeek.isSelected = true
            binding.btnMonth.isSelected = false
            daysViewModel.getWeeklySmokedJoints()?.observe(this@StatisticsActivity) {
                    smokedJoints -> binding.test.text = smokedJoints.toString()
            }
        }
        binding.btnMonth.setOnClickListener {
            binding.btnDay.isSelected = false
            binding.btnWeek.isSelected = false
            binding.btnMonth.isSelected = true
            daysViewModel.getMonthlySmokedJoints()?.observe(this@StatisticsActivity) {
                    smokedJoints -> binding.test.text = smokedJoints.toString()
            }
        }
    }

    private fun navigationHandler(){
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.menu_stats -> {
                    // Respond to navigation item 2 click
                    true
                }
                R.id.menu_add -> {
                    // Respond to navigation item 1 click
                    true
                }
                R.id.menu_settings -> {
                    // Respond to navigation item 2 click
                    true
                }
                else -> false
            }
        }
    }
}