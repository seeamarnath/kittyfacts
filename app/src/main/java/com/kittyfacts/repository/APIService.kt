package com.kittyfacts.repository

import com.kittyfacts.models.FactResponse
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("/facts")
    fun getFacts(): Call<FactResponse>
}