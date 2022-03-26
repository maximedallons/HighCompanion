package com.gami.highcompanion.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.gami.highcompanion.R
import com.gami.highcompanion.databinding.FragmentAddSmokedJointsBinding


class AddSmokedJoints : Fragment() {
    private lateinit var binding : FragmentAddSmokedJointsBinding

    companion object{
        fun newInstance(): AddSmokedJoints {
            return AddSmokedJoints()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        binding.testBtn.setOnClickListener { binding.testText.text = (Integer.parseInt(binding.testText.text as String) + 1).toString() }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddSmokedJointsBinding.inflate(inflater, container, false)
        return binding.root
    }

}

/*

 */