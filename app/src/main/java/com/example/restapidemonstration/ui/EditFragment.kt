package com.example.restapidemonstration.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.restapidemonstration.R
import com.example.restapidemonstration.data.Destination
import com.example.restapidemonstration.databinding.FragmentEditBinding
import com.example.restapidemonstration.viewModel.MainViewModel

class EditFragment : Fragment() {

    private lateinit var binding : FragmentEditBinding
    private val args: EditFragmentArgs by navArgs()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getDestination(args.id)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        viewModel.destination.observe(viewLifecycleOwner){
            binding.etCity.setText(it?.city)
            binding.etCountry.setText(it?.country)
            binding.etDescription.setText(it?.description)
        }

        binding.button.apply {
            setOnClickListener {
                val destination = Destination(
                    binding.etCity.text.toString(),
                    binding.etCountry.text.toString(),
                    binding.etDescription.text.toString(),
                    null
                )
                viewModel.editDestination(args.id, destination)
                Toast.makeText(context, "Updated id : ${args.id}", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.edit_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.delete_destination -> {
                viewModel.deleteDestination(args.id)
                Toast.makeText(requireContext(), "Deleted destination: Id ${args.id}", Toast.LENGTH_SHORT).show()
                activity?.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}