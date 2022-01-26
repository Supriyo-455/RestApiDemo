package com.example.restapidemonstration.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restapidemonstration.R
import com.example.restapidemonstration.databinding.FragmentHomeBinding
import com.example.restapidemonstration.viewModel.MainViewModel

class HomeFragment : Fragment() {

    private val adapter: HomeFragmentAdapter = HomeFragmentAdapter()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        binding.rvHome.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHome.adapter = adapter

        viewModel.destinations.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            Toast.makeText(
                requireContext(), "Destinations loaded!", Toast
                    .LENGTH_SHORT
            )
                .show()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getDestinations()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.actionbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.refresh -> {
                viewModel.getDestinations()
                true
            }
            R.id.addDestination -> {
                val action = HomeFragmentDirections.actionHomeFragmentToCreateFragment()
                findNavController().navigate(action)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}