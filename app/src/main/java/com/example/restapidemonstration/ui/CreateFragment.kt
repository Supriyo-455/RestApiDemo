package com.example.restapidemonstration.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.restapidemonstration.R
import com.example.restapidemonstration.data.Destination
import com.example.restapidemonstration.databinding.FragmentCreateBinding
import com.example.restapidemonstration.viewModel.MainViewModel

class CreateFragment : Fragment() {

    private lateinit var binding : FragmentCreateBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateBinding.inflate(inflater, container, false)

        binding.button.apply {
            setOnClickListener {
                val destination = Destination(
                    binding.etCity.text.toString(),
                    binding.etCountry.text.toString(),
                    binding.etDescription.text.toString(),
                    null
                )
                viewModel.createDestination(destination)
                Toast.makeText(context, "Created : ${binding.etCity.text}", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

}