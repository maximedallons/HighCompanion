package com.gami.highcompanion.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.gami.highcompanion.R
import com.gami.highcompanion.databinding.ActivityAddBinding
import com.gami.highcompanion.views.fragments.AddSmokedJoints
import java.lang.reflect.Array.newInstance


class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        initViewAttributes()
        switchDataTypeHandler()
        navigationHandler()

        val currentFragment: Fragment? =
            supportFragmentManager.findFragmentById(R.id.smoked_joints_fragment)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.smoked_joints_fragment, AddSmokedJoints.newInstance()).commit()
        }

    }

    private fun navigationHandler(){
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.menu_stats -> {
                    val statsActivityIntent = Intent(this, StatisticsActivity::class.java)
                    startActivity(statsActivityIntent)
                    overridePendingTransition(0,0)
                    true
                }
                R.id.menu_add -> {
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

    private fun switchDataTypeHandler(){
        var flag = true
        binding.switchBtn.setOnClickListener {
            if(flag) {
                binding.switchBtn.setImageResource(R.drawable.back_to_weed)
                binding.title.text = "Transactions"
                binding.smokedJointsFragment.visibility = View.GONE
                flag = !flag
            }
            else if(!flag) {
                binding.switchBtn.setImageResource(R.drawable.back_to_money)
                binding.title.text = "Smoke a joint"
                binding.smokedJointsFragment.visibility = View.VISIBLE
                flag = !flag
            }
        }
    }

    private fun initViewAttributes() {
        binding.bottomNavigation.selectedItemId = R.id.menu_add
    }
}