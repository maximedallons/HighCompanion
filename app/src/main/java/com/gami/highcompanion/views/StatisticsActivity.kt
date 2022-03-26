package com.gami.highcompanion.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.gami.highcompanion.R
import com.gami.highcompanion.databinding.ActivityStatisticsBinding
import com.gami.highcompanion.viewmodels.DaysViewModel

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
        binding.bottomNavigation.selectedItemId = R.id.menu_stats
        daysViewModel.getDailySmokedJoints()?.observe(this@StatisticsActivity) {
                smokedJoints ->  if(smokedJoints == null) binding.smokedJoints.text = 0.toString() else binding.smokedJoints.text = smokedJoints.toString()
        }
        daysViewModel.getDailySpentAmount()?.observe(this@StatisticsActivity) {
                spentMoney -> if(spentMoney == null) binding.spentMoney.text = 0.toString() + "€" else binding.spentMoney.text = roundTo2Decimals(spentMoney).toString() + "€"
        }
    }

    private fun rangeSelectorHandler(){
        binding.btnDay.setOnClickListener {
            binding.btnDay.isSelected = true
            binding.btnWeek.isSelected = false
            binding.btnMonth.isSelected = false
            daysViewModel.getDailySmokedJoints()?.observe(this@StatisticsActivity) {
                    smokedJoints ->  if(smokedJoints == null) binding.smokedJoints.text = 0.toString() else binding.smokedJoints.text = smokedJoints.toString()
            }
            daysViewModel.getDailySpentAmount()?.observe(this@StatisticsActivity) {
                    spentMoney -> if(spentMoney == null) binding.spentMoney.text = 0.toString() + "€" else binding.spentMoney.text = roundTo2Decimals(spentMoney).toString() + "€"
            }
        }
        binding.btnWeek.setOnClickListener {
            binding.btnDay.isSelected = false
            binding.btnWeek.isSelected = true
            binding.btnMonth.isSelected = false
            daysViewModel.getWeeklySmokedJoints()?.observe(this@StatisticsActivity) {
                    smokedJoints ->  if(smokedJoints == null) binding.smokedJoints.text = 0.toString() else binding.smokedJoints.text = smokedJoints.toString()
            }
            daysViewModel.getWeeklySpentAmount()?.observe(this@StatisticsActivity) {
                    spentMoney -> if(spentMoney == null) binding.spentMoney.text = 0.toString() + "€" else binding.spentMoney.text = roundTo2Decimals(spentMoney).toString() + "€"
            }
        }
        binding.btnMonth.setOnClickListener {
            binding.btnDay.isSelected = false
            binding.btnWeek.isSelected = false
            binding.btnMonth.isSelected = true
            daysViewModel.getMonthlySmokedJoints()?.observe(this@StatisticsActivity) {
                    smokedJoints ->  if(smokedJoints == null) binding.smokedJoints.text = 0.toString() else binding.smokedJoints.text = smokedJoints.toString()
            }
            daysViewModel.getMonthlySpentAmount()?.observe(this@StatisticsActivity) {
                    spentMoney -> if(spentMoney == null) binding.spentMoney.text = 0.toString() + "€" else binding.spentMoney.text = roundTo2Decimals(spentMoney).toString() + "€"
            }
        }
    }

    private fun navigationHandler(){
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.menu_stats -> {
                    true
                }
                R.id.menu_add -> {
                    val addActivityIntent = Intent(this, AddActivity::class.java)
                    startActivity(addActivityIntent)
                    overridePendingTransition(0,0)
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

    private fun roundTo2Decimals(n:Double) : Double{
        return String.format("%.3f", n).toDouble()
    }
}