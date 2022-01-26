package com.example.restapidemonstration.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.restapidemonstration.R
import com.example.restapidemonstration.data.Destination
import com.example.restapidemonstration.data.Destinations
import com.example.restapidemonstration.databinding.ListItemHomeBinding


class HomeFragmentAdapter : ListAdapter<Destination, HomeFragmentAdapter.HomeViewHolder>(HomeDiffCallBack()) {

    class HomeViewHolder(
        val binding : ListItemHomeBinding
    ): RecyclerView.ViewHolder(binding.root)

    private class HomeDiffCallBack : DiffUtil.ItemCallback<Destination>(){
        override fun areItemsTheSame(oldItem: Destination, newItem:Destination): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Destination, newItem: Destination): Boolean {
            return oldItem.toString() == newItem.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater : LayoutInflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemHomeBinding.inflate(inflater, parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val destination = getItem(position)
        holder.binding.tvTitle.text = destination.city
        holder.binding.tvCountry.text = destination.country
        holder.binding.tvDescription.text = destination.description

        holder.binding.root.apply {
            setOnClickListener {
                val navController = findNavController()
                Toast.makeText(context, "City : ${holder.binding.tvTitle.text} clicked!", Toast.LENGTH_SHORT).show()
                val action = HomeFragmentDirections.actionHomeFragmentToEditFragment(destination.id!!)
                navController.navigate(action)
            }
        }
    }
}