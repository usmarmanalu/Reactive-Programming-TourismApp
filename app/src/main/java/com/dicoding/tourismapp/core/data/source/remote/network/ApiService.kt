package com.dicoding.tourismapp.core.data.source.remote.network

import com.dicoding.tourismapp.core.data.source.remote.response.*
import retrofit2.http.*

interface ApiService {
    @GET("list")
    suspend fun getList(): ListTourismResponse
}
