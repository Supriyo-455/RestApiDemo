package com.example.restapidemonstration.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.restapidemonstration.R
import com.example.restapidemonstration.databinding.FragmentWelcomeBinding
import com.example.restapidemonstration.viewModel.MainViewModel

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getWelcomeMessage()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)

        viewModel.message.observe(viewLifecycleOwner) {
            binding.tvWelcome.setText(it?.message)
        }

        binding.btnContinue.apply {
            setOnClickListener {
                val action = WelcomeFragmentDirections.actionWelcomeFragmentToHomeFragment()
                findNavController().navigate(action)
            }
        }

        return binding.root
    }


}