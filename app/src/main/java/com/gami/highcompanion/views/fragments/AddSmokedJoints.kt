package com.gami.highcompanion.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gami.highcompanion.databinding.FragmentAddSmokedJointsBinding
import com.gami.highcompanion.models.DayStats
import com.gami.highcompanion.viewmodels.AddViewModel
import java.time.LocalDate
import kotlin.math.abs


class AddSmokedJoints : Fragment() {
    private lateinit var binding : FragmentAddSmokedJointsBinding
    private lateinit var viewModel : AddViewModel
    private var barValue : Double = 0.0

    companion object{
        fun newInstance(): AddSmokedJoints {
            return AddSmokedJoints()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel = AddViewModel()
        binding = FragmentAddSmokedJointsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        seekBarHandler()
        addBtnHandler()
        removeBtnHandler()
    }

    private fun seekBarHandler(){
        binding.seekBar.setOnProgressChangeListener { progressValue ->
            barValue = abs(100 - progressValue.toDouble())/100
        }
    }

    private fun addBtnHandler(){
        binding.addBtn.setOnClickListener {
            var flag = true
            viewModel.getDayStats()?.observe(viewLifecycleOwner){
                    dayStats ->
                if(flag) {
                    flag = false
                    if (dayStats == null) {
                        viewModel.addDay(DayStats(LocalDate.now(), barValue, 0.0))
                    } else {
                        viewModel.addSmokedJoint(barValue)
                    }
                }
            }
            activity?.onBackPressed()
        }
    }

    private fun removeBtnHandler(){
        binding.removeBtn.setOnClickListener {
            var flag1 = true
            var flag2 = true
            viewModel.getDayStats()?.observe(this){
                    dayStats ->
                if(flag1) {
                    flag1 = false
                    if (dayStats != null) {
                        viewModel.getDailySmokedJoints()?.observe(this){
                                smokedJoints ->
                            if(flag2) {
                                flag2 = false
                                if (smokedJoints - barValue > 0) {
                                    viewModel.substractSmokedJoint(barValue)
                                } else {
                                    viewModel.resetSmokedJoints()
                                }
                            }
                        }
                    }
                }
            }
            activity?.onBackPressed()
        }
    }
}