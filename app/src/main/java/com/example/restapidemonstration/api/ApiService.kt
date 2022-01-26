package com.example.restapidemonstration.api

import com.example.restapidemonstration.data.Destination
import com.example.restapidemonstration.data.Destinations
import com.example.restapidemonstration.data.Message
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("destinations")
    suspend fun getDestinations()
        : Response<Destinations>

    @GET("destinations/{id}")
    suspend fun getDestination(@Path("id") id : Int)
        : Response<Destination>

    @GET("messages")
    suspend fun getWelcomeMessage()
        : Response<Message>

    @POST("destinations")
    suspend fun createDestination(@Body destination : Destination)
        : Response<Destination>

    @PUT("destinations/{id}")
    suspend fun editDestination(
        @Path("id") id : Int,
        @Body destination : Destination
    ) : Response<Destination>

    @DELETE("destinations/{id}")
    suspend fun deleteDestination(
        @Path("id") id : Int
    ) : Response<Destination>
}