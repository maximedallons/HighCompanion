package com.gami.highcompanion.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gami.highcompanion.R
import com.gami.highcompanion.databinding.FragmentAddSpentMoneyBinding
import com.gami.highcompanion.viewmodels.AddViewModel

class AddSpentMoney : Fragment() {
    private lateinit var binding : FragmentAddSpentMoneyBinding
    private lateinit var viewModel : AddViewModel
    private var state : Boolean = true

    companion object{
        fun newInstance(): AddSmokedJoints {
            return AddSmokedJoints()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewModel = AddViewModel()
        binding = FragmentAddSpentMoneyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.spentMoney.text = ""
        handleKeyboardClicks()
    }

    private fun addTospentMoneyText(text: String) : String{
        return binding.spentMoney.text.toString() + text
    }

    //Handle all the kb_* click listeners
    private fun handleKeyboardClicks(){
        binding.kb0.setOnClickListener {
            binding.spentMoney.text = addTospentMoneyText("0")
        }
        binding.kb1.setOnClickListener {
            binding.spentMoney.text = addTospentMoneyText("1")
        }
        binding.kb2.setOnClickListener {
            binding.spentMoney.text = addTospentMoneyText("2")
        }
        binding.kb3.setOnClickListener {
            binding.spentMoney.text = addTospentMoneyText("3")
        }
        binding.kb4.setOnClickListener {
            binding.spentMoney.text = addTospentMoneyText("4")
        }
        binding.kb5.setOnClickListener {
            binding.spentMoney.text = addTospentMoneyText("5")
        }
        binding.kb6.setOnClickListener {
            binding.spentMoney.text = addTospentMoneyText("6")
        }
        binding.kb7.setOnClickListener {
            binding.spentMoney.text = addTospentMoneyText("7")
        }
        binding.kb8.setOnClickListener {
            binding.spentMoney.text = addTospentMoneyText("8")
        }
        binding.kb9.setOnClickListener {
            binding.spentMoney.text = addTospentMoneyText("9")
        }

        binding.kbDel.setOnClickListener {
            if(binding.spentMoney.text.toString().isNotEmpty()){
                binding.spentMoney.text = binding.spentMoney.text.toString().substring(0, binding.spentMoney.text.toString().length - 1)
            }
        }
        binding.kbDot.setOnClickListener {
            if(binding.spentMoney.text.toString().isNotEmpty()){
                binding.spentMoney.text = addTospentMoneyText(".")
            }
        }
        binding.kbAccept.setOnClickListener {
            if(state){
                viewModel.addSpentMoney(binding.spentMoney.text.toString().toDouble())
            }
            else{
                viewModel.substractSpentMoney(binding.spentMoney.text.toString().toDouble())
            }
            binding.spentMoney.text = ""
            activity?.onBackPressed()
        }

        binding.switchBtn.setOnClickListener {
            state = if(state){
                binding.rectangle.setBackgroundResource(R.drawable.red_rounded_rectangle)
                false
            } else{
                binding.rectangle.setBackgroundResource(R.drawable.green_rounded_rectangle)
                true
            }
        }

    }
}