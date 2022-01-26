package com.example.restapidemonstration.repository

import com.example.restapidemonstration.api.ApiClient
import com.example.restapidemonstration.data.Destination
import com.example.restapidemonstration.data.Message

class MainRepository {
    private val api = ApiClient.api

    suspend fun getDestinations() : List<Destination>? {
        val response = api.getDestinations()
        return response.body()?.destinations
    }

    suspend fun getDestination(id : Int) : Destination? {
        val response = api.getDestination(id)
        return response.body()
    }

    suspend fun getWelcomeMessage() : Message? {
        val response = api.getWelcomeMessage()
        return response.body()
    }

    suspend fun createDestination(destination: Destination) : Destination? {
        val response = api.createDestination(destination)
        return response.body()
    }

    suspend fun editDestination(id : Int, destination: Destination) : Destination? {
        val response = api.editDestination(id, destination)
        return response.body()
    }

    suspend fun deleteDestination(id : Int) : Destination? {
        val response = api.deleteDestination(id)
        return response.body()
    }
}