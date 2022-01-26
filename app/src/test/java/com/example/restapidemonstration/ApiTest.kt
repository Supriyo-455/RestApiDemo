package com.example.restapidemonstration

import com.example.restapidemonstration.api.ApiClient
import com.example.restapidemonstration.data.Destination
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ApiTest {
    private val api = ApiClient.api

    @Test
    fun `get message working`() =
        runBlocking {
            val response = api.getWelcomeMessage()
            assertNotNull(response.body())
        }


    @Test
    fun `get destinations working`() =
        runBlocking {
            val response = api.getDestinations()
            assertNotNull(response.body())
        }

    @Test
    fun `get destination working`() =
        runBlocking {
            val response = api.getDestination(5)
            assertNotNull(response.body())
        }

    @Test
    fun `create destination working`() =
        runBlocking {
            val destination = Destination(
                "Osaka",
                "Japan",
                "Beautiful city",
                null
            )
            val response = api.createDestination(destination)
            assertNotNull(response.body())
        }

    @Test
    fun `update destination working`() =
        runBlocking {
            val destination = Destination(
                "Osaka",
                "Japan",
                "Beautiful and calm city",
                null
            )
            val response = api.editDestination(7, destination)
            assertNotNull(response.body())
        }

    @Test
    fun `delete destination working`() =
        runBlocking {
            val response = api.deleteDestination(7)
            assertNotNull(response)
        }
}