package com.example.restapidemonstration.api

import com.example.restapidemonstration.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val retrofit : Retrofit by lazy{
        Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
    }

    val api : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}